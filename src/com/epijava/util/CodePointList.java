/*
 * 
 */
package com.epijava.util;

import java.util.*;

/**
 * Implements a list of Unicode code points (i.e. - a String)
 * 
 * <p>
 * Is immutable: mutation APIs (modelled after those in java.lang.String) return
 * a new CodePointList object.
 * 
 */
public final class CodePointList implements List<CodePoint> {

    private final char[] characters;
    private final int offset;
    private final int count;
    
    public CodePointList(String s) {
        this(s.toCharArray(), 0, s.length());
    }
    
    public CodePointList(char[] characters) {
        this(copy(characters), 0, characters.length);
    }
    
    private static char[] copy(char[] v) {
        char[] r = new char[v.length];
        System.arraycopy(v, 0, r, 0, v.length);
        return r;
    }
    
    private CodePointList(char[] _characters, int _offset, int _count) {
        characters = _characters;
        offset = _offset;
        count = _count;
    }

    public boolean contains(Object v) {
        if (v == null || !(v instanceof CodePoint))
            return false;
        
        for (CodePoint cp : this)
            if (cp.equals(v))
                return true;
        
        return false;
    }

    public boolean containsAll(Collection<?> that) {
        for (Object v : that)
            if (!contains(v))
                return false;
        return true;
    }

    public CodePoint get(int idx) {
        return CodePoint.valueOf(Character.codePointAt(characters, idx + offset));
    }

    public int indexOf(Object v) {
        if (v == null || !(v instanceof CodePoint))
            return -1;
        
        int r = 0;
        for (CodePoint cp : this)
            if (cp.equals(v))
                return r;
            else
                r++;
        
        return -1;    
    }

    public boolean isEmpty() {
        return count > 0;
    }

    public Iterator<CodePoint> iterator() {
        return new Iterator<CodePoint>() {
            
            private int idx = 0;
            private final int lastIdx = size();

            public boolean hasNext() {
                return idx < lastIdx;
            }

            public CodePoint next() {
                return get(idx++);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        };
    }

    public int lastIndexOf(Object arg0) {
        throw new UnsupportedOperationException("XXX not done");
    }

    public ListIterator<CodePoint> listIterator() {
        return new ListIterator<CodePoint>() {
            
            private int idx = 0;
            private final int lastIdx = size();

            public void add(CodePoint o) {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return idx < lastIdx;
            }

            public boolean hasPrevious() {
                return idx >= 0;
            }

            public CodePoint next() {
                return get(idx++);
            }

            public int nextIndex() {
                return idx++;
            }

            public CodePoint previous() {
                return get(idx--);
            }

            public int previousIndex() {
                return idx--;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(CodePoint o) {
                throw new UnsupportedOperationException();
            }
            
        };
    }

    public ListIterator<CodePoint> listIterator(int arg0) {
        throw new UnsupportedOperationException("XXX not done");
    }
    
    public int size() {
        return Character.codePointCount(characters, offset, count);
    }

    public List<CodePoint> subList(int _offset, int _count) {
        if (_offset < 0 || _count < 0)
            throw new IndexOutOfBoundsException("XXX A");
        
        if (offset+_offset+_count > count)
            throw new IndexOutOfBoundsException("XXX B");
        
        return new CodePointList(characters, offset+_offset, _count);
    }

    public Object[] toArray() {
        CodePoint[] r = new CodePoint[size()];
        int idx = 0;
        for (CodePoint cp : this)
            r[idx++] = cp;
        return r;
    }

    public <T> T[] toArray(T[] arg0) {
        throw new UnsupportedOperationException("XXX not done");
    }
    
    public String toString() { return new String(characters, offset, count); }

    
    // unsupported direct mutation API of list.
    
    public boolean add(CodePoint arg0) {
        throw new UnsupportedOperationException();
    }
    
    public void add(int arg0, CodePoint arg1) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends CodePoint> arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int arg0, Collection<? extends CodePoint> arg1) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public CodePoint remove(int arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    public CodePoint set(int arg0, CodePoint arg1) {
        throw new UnsupportedOperationException();
    }


}
