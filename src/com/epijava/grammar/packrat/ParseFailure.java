/*
 * 
 */
package com.epijava.grammar.packrat;

import com.epijava.grammar.*;
import com.epijava.grammar.Grammar.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class ParseFailure {
    
    public static final Object EOF = new Object() {
        public String toString() { return "EOF"; }
    };
    
    private final int subparseDepth;
    private final int pos;
    private final Locus locus;
    
    
    private final Grammar expected;
    private final Object got;

    
    public static ParseFailure expected(ParserState<?> parse, Grammar _wanted) {
        return new ParseFailure(parse, _wanted);
    }

    public ParseFailure(ParserState<?> parse, Grammar _expected) {
        this(parse.getSubparseDepth(), parse.getPos(), parse.getCurrentLocus(), parse.peekOrEof(), _expected); 
    }
    public ParseFailure(int _subparseDepth, int _pos, Locus _locus, Object _got, Grammar _expected) {
        subparseDepth = _subparseDepth;
        pos = _pos;
        locus = _locus;
        got = _got;
        expected = _expected;
    }

    public int getSubparseDepth() {
        return subparseDepth;
    }
    
    public int getPos() {
        return pos;
    }
    
    public Object getGot() {
        return got;
    }
    
    public Grammar getExpected() {
        return expected;
    }
    
    public String getMessage() {
        return "expected "+expected+", got "+got;
    }

    public String toString() {
        return "ERROR: " + subparseDepth + "/" + pos + ":" + getMessage();
    }

    public boolean isMoreRelevantThan(ParseFailure that) {
        if (this.subparseDepth > that.subparseDepth)
            return true;
        if (this.pos > that.pos)
            return true;
        return false;
    }

    public ParseFailure joinWith(ParseFailure that) {
        if (this.isMoreRelevantThan(that))
            return this;
        else if (that.isMoreRelevantThan(this))
            return that;
        else {
            return new ParseFailure(subparseDepth, pos, locus, got, expected.or(that.expected));
        }
    }

    public static ParseFailure join(ParseFailure a, ParseFailure b) {
        if (a == null) return b;
        if (b == null) return a;
        return a.joinWith(b);
    }

    public ParseFailure annotate(RuleGrammar rule, int startPos) {
        if (startPos == pos)
            return new ParseFailure(subparseDepth, pos, locus, got, rule);
        else
            return this;
    }
}
