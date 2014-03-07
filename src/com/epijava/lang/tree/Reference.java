/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * Represents a reference to some named Java declaration (type, method,
 * variable, etc)
 * 
 * <p>
 * Subclasses specialize this into different types of references.
 */
public abstract class Reference<T extends Definition> extends Expression {
    
    private T definition;

    public Reference(Locus _locus) {
        super(_locus);
    }
    
    @SuppressWarnings("unchecked")
    public Reference<T> setType(Type t) {
        return (Reference<T>)super.setType(t);
    }
    
    /**
     * Set the declaration referenced by this reference.
     * 
     * <p>
     * Set by the reference binder.
     */
    public Reference<T> setDefinition(T v) {
        definition = v;
        return this;
    }

    /**
     * Fetch the declaration referenced by this reference.
     * 
     * <p>
     * If the reference binder has not been invoked, this will return NULL.
     */
    public T getDefinition() {
        return definition;
    }

}
