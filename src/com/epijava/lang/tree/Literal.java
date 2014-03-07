/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public abstract class Literal<T> extends Expression {

    /**
     * @param _locus
     */
    public Literal(Locus _locus) {
        super(_locus);
    }
    
    public abstract T getValue();

}
