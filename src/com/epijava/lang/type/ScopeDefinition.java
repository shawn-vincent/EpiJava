/*
 * 
 */
package com.epijava.lang.type;

/**
 * A Definition that contains other Definitions (i.e. - is a Java scope)
 * 
 * <p>Base class of Packages and Types
 *
 */
public abstract class ScopeDefinition extends Definition implements JavaScope {

    public ScopeDefinition() {
        super();
    }

    public ScopeDefinition(Type type) {
        super(type);
    }

    @Override
    public abstract JavaName<? extends Definition> getName();

    @Override
    public abstract Type getType();

    public abstract <T extends Definition> T getDefinition(JavaName<T> name);

}
