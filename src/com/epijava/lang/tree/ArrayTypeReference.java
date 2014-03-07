/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class ArrayTypeReference extends TypeReference {

    private final TypeReference componentType;
    
    /**
     * 
     */
    public ArrayTypeReference(Locus _locus, TypeReference _componentType) {
        super(_locus);
        componentType = _componentType;
    }
    
    public TypeReference getComponentType() { return componentType; }

}
