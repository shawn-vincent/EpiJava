/*
 * 
 */
package com.epijava.lang.tree;

import java.util.ArrayList;
import java.util.List;

import com.epijava.util.*;

/**
 * 
 *
 */
public class ClassDeclaration extends TypeDeclaration {
    
    private TypeReference superType;
    private List<TypeReference> interfaces = new ArrayList<TypeReference>();

    /**
     * 
     */
    public ClassDeclaration(Locus _locus, String _name) {
        super(_locus, _name);
    }

    public TypeReference getSuperType() { return superType; }
    public ClassDeclaration setSuperType(TypeReference v) {
        superType = v;
        return this;
    }

    public List<TypeReference> getInterfaces() { return interfaces; }
    public ClassDeclaration setInterfaces(List<TypeReference> v) {
        interfaces = v;
        return this;
    }

}
