/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class VarReference extends ExprReference {
   
    private final String name;
   
    public VarReference(Locus _locus, String _name) {
        super(_locus);
        name = _name;
    }
    
    public String getName() { return name; }

   
    
}
