/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * XXX boring intermediate subclass
 *
 */
public abstract class MemberDeclaration<T extends Definition> extends Declaration<T> {

    public MemberDeclaration(Locus _locus, String _name) {
        super(_locus, _name);
    }


}
