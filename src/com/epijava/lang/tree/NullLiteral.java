package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * 
 * 
 *
 */
public class NullLiteral extends Literal<Object> {

    public NullLiteral(Locus _locus) {
        super(_locus);
    }
    
    public Object getValue() {
        return null;
    }

}
