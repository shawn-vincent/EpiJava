/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class FieldReference extends ExprReference {

    private final Expression self;
    private final String name;
    
    public FieldReference(Locus _locus, Expression _self, String _name) {
        super(_locus);
        self = _self;
        name = _name;
    }

    public Expression getSelf() {
        return self;
    }

    public String getName() {
        return name;
    }

}
