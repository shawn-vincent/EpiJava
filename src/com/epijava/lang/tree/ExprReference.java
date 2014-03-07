/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * abstract supertype of FieldReferences and VarReferences.
 *
 */
public abstract class ExprReference extends Reference<Var> {

    public ExprReference(Locus _locus) {
        super(_locus);
    }

}
