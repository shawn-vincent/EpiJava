/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 * 
 */
public class LongLiteral extends NumberLiteral<Long> {

    private final int radix;

    public LongLiteral(Locus _locus, Long _value) {
        this(_locus, _value, 10);
    }

    public LongLiteral(Locus _locus, Long _value, int _radix) {
        super(_locus, _value);
        radix = _radix;
    }
    
    public int getRadix() { return radix; }

}