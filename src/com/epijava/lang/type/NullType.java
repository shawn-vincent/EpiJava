/*
 * 
 */
package com.epijava.lang.type;


/**
 * 
 *
 */
public class NullType<T> extends SimpleType<T> {

    protected NullType() {
        super(null);
    }

    public <D extends Definition> D getDefinition(JavaName<D> name) {
        return null;
    }

}
