/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 * 
 */
public class IntLiteral extends NumberLiteral<Integer> {

    private final int radix;
    
    public IntLiteral(Locus _locus, Integer _value) {
        this(_locus, _value, 10);
    }

    public IntLiteral(Locus _locus, Integer _value, int _radix) {
        super(_locus, _value);
        radix = _radix;
    }
    
    public int getRadix() { return radix; }

    public static Expression makeDecimal(Locus l, String text) {
        if (text.endsWith("L") || text.endsWith("l")) {
            return new LongLiteral(l, Long.parseLong(text.substring(0, text
                    .length() - 1)), 10);
        } else {
            return new IntLiteral(l, Integer.parseInt(text), 10);
        }

    }

    public static Expression makeHex(Locus l, String text) {
        throw new UnsupportedOperationException();
    }

    public static Expression makeOctal(Locus l, String text) {
        throw new UnsupportedOperationException();
    }
}
