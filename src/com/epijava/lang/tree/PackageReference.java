/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.lang.type.Package;
import com.epijava.util.*;

/**
 * 
 *
 */
public class PackageReference extends Reference<Package> {
    
    private final PackageReference parent;
    private final String name;

    public PackageReference(Locus _locus, String _name) {
        this(_locus, null, _name);
    }
    
    public PackageReference(Locus _locus, PackageReference _parent, String _name) {
        super(_locus);
        parent = _parent;
        name = _name;
        
        if (name == null)
            throw new NullPointerException();
    }

    public PackageReference getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        if (parent == null)
            return name;
        else
            return parent + "." + name;
    }

    public JavaName<Package> getPackageName() {
        return JavaName.pkg(toString());
    }

}
