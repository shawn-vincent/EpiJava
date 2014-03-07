/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class CharLiteral extends Literal<Character> {

    private final Character value;
    
    /**
     * @param _locus
     */
    public CharLiteral(Locus _locus, Character _value) {
        super(_locus);
        value = _value;
        if (value == null)
            throw new NullPointerException();
    }

    @Override
    public Character getValue() {
        return value;
    }

    public static Expression make(Locus l, String text) {
        throw new UnsupportedOperationException();
    }

}
