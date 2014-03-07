/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class FunctionTypeReference extends TypeReference {

    private final TypeReference returnType;
    
    // XXX parameter types, exception types
    
    /**
     * @param _locus
     */
    public FunctionTypeReference(Locus _locus, TypeReference _returnType) {
        super(_locus);
        
        returnType = _returnType;
    }

    public TypeReference getReturnType() {
        return returnType;
    }

}
