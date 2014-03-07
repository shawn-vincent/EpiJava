/*
 * 
 */
package com.epijava.lang.type;


/**
 * Base class for all EpiJava types
 *
 */
public abstract class Type extends ScopeDefinition {

    public Type() {
        super();
    }

    public Type(Type type) {
        super(type);
    }

    public <T extends Definition> T getDefinition(JavaName<T> name) {
        return null;
    }

    public abstract JavaName<Type> getName();

    public Type getType() { return this; }
}
