/*
 *
 *
 */
package com.epijava.util;

import java.util.*;

/**
 * A java qualified name (ID.ID.ID...)
 **/
public class QualifiedName implements Locus {
    private final Locus locus;
    private final String[] components;

    public QualifiedName(String... _components)
    { this(Locus.Unknown, _components); }
    public QualifiedName(Locus _locus, String... _components)
    {
        locus = _locus; 
        components = _components; 
        
        if (locus == null)
            throw new NullPointerException();
        
        if (components == null)
            throw new NullPointerException();
        
        if (components.length == 0)
            throw new IllegalArgumentException
            ("Cannot construct QualifiedName with empty name");
    }

    public QualifiedName(Locus _locus, Collection<String> _components)
    { this(_locus, (String[])_components.toArray(new String[_components.size()])); }

    public Locus getLocus() { return locus; }
    public String[] getComponents() { return components; }

    public String locusModule() { return locus.locusModule(); }
    public int locusPosition() { return locus.locusPosition(); }

    public String toString() {
	StringBuilder r = new StringBuilder();
	boolean first = true;
	for (String s : components) {
	    if (first) first = false;
	    else r.append('.');
	    r.append(s);
	}
	return r.toString();
    }
    
    public boolean equals(Object _that) {
       QualifiedName that = (QualifiedName)_that;
       return Arrays.equals(this.components, that.components);
    }
    
    public int hashCode() {
        return Arrays.hashCode(components);
    }
    
    public String last() {
        return components[components.length-1];
    }
    public QualifiedName allButLast() {
        if (isSimpleName())
            throw new ArrayIndexOutOfBoundsException(
                    "Can't fetch allButLast of simple name");
        
        String[] newComponents = new String[components.length-1];
        System.arraycopy(components, 0, newComponents, 0, components.length-1);

        // XXX loss of locus information here!
        return new QualifiedName(locus, newComponents);
    }
    
    public boolean isSimpleName() {
        return components.length == 1;
    }
    
    public boolean isQualifiedName() {
        return components.length > 1;
    }
}