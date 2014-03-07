/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 */
public abstract class NumberLiteral<T extends Number> extends Literal<T> {

   private final T value;
    
    public NumberLiteral(Locus _locus, T _value) {
        super(_locus);
        value = _value;
        if (value == null)
            throw new NullPointerException();
    }

    @Override
    public T getValue() {
        return value;
    }

}
