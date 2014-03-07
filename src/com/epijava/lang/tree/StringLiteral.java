/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class StringLiteral extends Literal<String> {

    private final String value;
    
    public StringLiteral(Locus _locus, String _value) {
        super(_locus);
        value = _value;
        if (value == null)
            throw new NullPointerException();
    }

    @Override
    public String getValue() {
        return value;
    }

    public static Expression make(Locus l, String text) {
        throw new UnsupportedOperationException();
    }

}
