/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class FloatLiteral extends NumberLiteral<Float> {

    public FloatLiteral(Locus _locus, Float _value) {
        super(_locus, _value);
    }

    public static Expression make(Locus l, String text) {
        throw new UnsupportedOperationException();
    }

}