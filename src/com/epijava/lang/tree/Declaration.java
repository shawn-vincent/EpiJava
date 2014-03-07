/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public abstract class Declaration<T extends Definition> extends Expression {
    
    // XXX should all declarations have a name?
    private final String name;
    
    private final JavaName<T> javaName;
    
    /**
     * 
     */
    public Declaration(Locus _locus, String _name) {
        super(_locus);
        name = _name;
        if (_name == null)
            javaName = null;
        else
            javaName = new JavaName<T>(getNamespace(), name);
    }
    
    public abstract JavaNamespace<T> getNamespace();
    
    @AstValue
    public String getName() { return name; }

    public JavaName<T> getJavaName() {
        return javaName;
    }

}
