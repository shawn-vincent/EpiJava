/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class BooleanLiteral extends Literal<Boolean> {

    private final Boolean value;
    
    public BooleanLiteral(Locus _locus, Boolean _value) {
        super(_locus);
        value = _value;
        if (value == null)
            throw new NullPointerException();
    }

    @Override
    public Boolean getValue() {
        return value;
    }

}
