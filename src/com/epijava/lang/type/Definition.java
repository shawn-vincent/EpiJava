/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 * 
 *
 */
public abstract class Definition {
    
    private final Type enclosingType;
    
    public Definition(Type _enclosingType) { enclosingType = _enclosingType; }
    public Definition() { this(null); }

    public abstract JavaName<? extends Definition> getName();
    
    public abstract Type getType();
    
    /**
     * Definitions may be nested inside Types: this returns the enclosing type
     * for any Definition.
     * 
     * <p>
     * Returns NULL for a top level definition.
     */
    public Type getEnclosingType() { return enclosingType; }
    
}
