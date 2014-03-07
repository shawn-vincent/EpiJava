/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

import com.epijava.util.*;
import com.epijava.util.Locus.*;

/**
 * 
 */
public abstract class LocusBuilder {

    public abstract Locus buildLocus(Object obj, int position);

    /**
     *
     */
    public static class CharStreamLocusBuilder extends LocusBuilder {
        
        private final ObjectStream<?> stream;
        private final String locusModule;
        
        private final List<LocusModifier> locusModifiers = new ArrayList<LocusModifier>();
        private int currentPosition = 0;
        private int currentLine = 0;
        private int currentCol = 0;
        
        public CharStreamLocusBuilder(ObjectStream<?> _stream, String _locusModule) {
            stream = _stream;
            locusModule = _locusModule;
            locusModifiers.add(new LocusModifier(0, 0, 0));
        }
        
        @Override
        public Locus buildLocus(Object obj, int position) {
            readUntil(position);
            LocusModifier relevantModifier = findRelevantLocusModifier(position);
            return relevantModifier.buildLocus(locusModule, position);
        }

        private LocusModifier findRelevantLocusModifier(int position) {
            int idx = Collections.binarySearch(locusModifiers, new LocusModifier(position));
            LocusModifier relevantModifier = locusModifiers.get(idx >= 0 ? idx : -idx-2);
            return relevantModifier;
        }
        
        private void readUntil(int position) {
            if (position >= stream.size())
                position = stream.size()-1;
//                throw new IndexOutOfBoundsException(
//                        "Tried to read until position " + position
//                                + " on stream that only has " + stream.size()
//                                + " values");
            
            if (currentPosition >= position)
                return;
            
            int start = currentPosition;
            
            Object prevCh = start-1 < 0 ? null : stream.get(start-1);
            Object ch = stream.get(start);

            for (int i=start; i<=position; i++) {

                processChar(i, prevCh, ch);
                
                prevCh = ch;
                ch = i+1<=position ? stream.get(i+1) : null;
            }
            
            currentPosition = position+1;
        }
        
        static final CodePoint Tab = CodePoint.valueOf('\t');
        static final CodePoint LF = CodePoint.valueOf('\n');
        static final CodePoint CR = CodePoint.valueOf('\r');
        
        private void processChar(int pos, Object prevCh, Object ch) {
            /*
             * LF: Multics, Unix and Unix-like systems (GNU/Linux, AIX, Xenix,
             * Mac OS X, FreeBSD, etc.), BeOS, Amiga, RISC OS, and others
             * 
             * CR+LF: DEC RT-11 and most other early non-Unix, non-IBM OSes,
             * CP/M, MP/M, DOS, OS/2, Microsoft Windows, Symbian OS
             * 
             * CR: Commodore machines, Apple II family, Mac OS up to version 9
             * and OS-9
             */

            /*
             * So there's 3 cases:
             * 
             *     a b c d CR e
             * 
             *     a b c d LF e
             * 
             *     a b c d CR LF e
             * 
             * So, if (prevCh == CR && ch != LF), or...
             *        (prevCh == LF)
             * 
             */
            
            if (prevCh == LF || (prevCh == CR && ch != LF)) {
                currentLine++;
                currentCol = 0;
                locusModifiers.add(new LocusModifier(pos, currentLine, currentCol));
            }
            
            // consider tab characters?
        }

    }
    
    /**
     *
     */
    private static class LocusModifier implements Comparable<LocusModifier>{
        private final int position;
        private final int line;
        private final int col;
        
        /**
         * For making a key to search for...
         */
        private LocusModifier(int _position) 
        { this(_position, -1, -1); }
        
        private LocusModifier(int _position, int _line, int _col) 
        { position = _position; line = _line; col = _col; }
        
    
        public Locus buildLocus(String locusModule, int pos) {
            int offsetFromPosition = pos - position;
            return new ConstantLocus(locusModule, line, col+offsetFromPosition);
        }

        public int compareTo(LocusModifier that) {
            return this.position - that.position;
        }
    }
}
