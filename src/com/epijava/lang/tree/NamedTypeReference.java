/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * A reference to a named type: may be a class type, an interface type, or a type variable.
 *
 */
public class NamedTypeReference extends TypeReference {

    /**
     * The scope in which to find this name.
     */
    // typically, will be a TypeOrPackageReference
    private final Reference<? extends Definition> scope;
    
    private final String name;
    
    // XXX add generic constraints
    
    /**
     * 
     */
    public NamedTypeReference(Locus _locus, Reference<? extends Definition> _scope, String _name) {
        super(_locus);
        scope = _scope;
        name = _name;
    }
    
    public NamedTypeReference(Reference<? extends Definition> _scope, String _name) {
        this(Locus.Unknown, _scope, _name);
    }

    public String getName() { return name; }


    public String toString() {
        return "type reference " + scope + "." + name.toString();
    }

    public Reference<? extends Definition> getScope() {
        return scope;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final NamedTypeReference other = (NamedTypeReference) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (scope == null) {
            if (other.scope != null)
                return false;
        } else if (!scope.equals(other.scope))
            return false;
        return true;
    }


}
