/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * An 'ambiguous name', as specified by the JLS.
 * 
 * <p>
 * When parsing Java, you can't know what an expression of the form ID.ID.ID...
 * means until you can resolve context (local variables, field names, type
 * names, package names, etc). Thus, the parser has to make a simple
 * AmbiguousName element that gets transformed into something more meaningful
 * afterwards.
 * 
 * <p>
 * See JLS 3rd Edition: 6.5.2 - Reclassification of Contextually Ambiguous
 * Names
 * 
 */
public class AmbiguousReference extends Reference<Definition> {

    private final QualifiedName name;

    public AmbiguousReference(Locus _locus, QualifiedName _name) {
        super(_locus);
        name = _name;
    }

    public QualifiedName getName() {
        return name;
    }
    
    public String toString() {
        return name.toString();
    }

}
