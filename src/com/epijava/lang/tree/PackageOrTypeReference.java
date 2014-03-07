/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 *
 */
public class PackageOrTypeReference extends TypeReference {
    
    private final PackageOrTypeReference scope;
    private final String name;

    public PackageOrTypeReference(Locus _locus, PackageOrTypeReference _scope, String _name) {
        super(_locus);
        scope = _scope;
        
        if (_name == null) throw new NullPointerException();
        name = _name;
    }

    public PackageOrTypeReference getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }

    public boolean isSimpleName() {
        return scope == null;
    }

    public NamedTypeReference toNamedTypeReference() {
        return new NamedTypeReference(this, scope, name);
    }
    
    public String toString() {
        if (scope == null)
            return name;
        return scope + "." + name;
    }
    
    

}
