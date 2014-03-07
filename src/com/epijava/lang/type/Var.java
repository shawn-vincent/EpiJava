/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 *
 */
public abstract class Var extends Definition {

    public Var() {
        super();
    }

    public Var(Type type) {
        super(type);
    }

    @Override
    public Type getType() {
        throw new UnsupportedOperationException();
    }

}
