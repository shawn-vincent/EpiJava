/*
 * 
 */
package com.epijava.lang.type;

import com.epijava.lang.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class TypeCheckException extends EpiRuntimeException {

    private static final long serialVersionUID = 1L;
    
    // XXX hoist me to a supertype
    private final Locus locus;

    /**
     * 
     */
    public TypeCheckException(Locus _locus) {
        locus = _locus;
    }

    public TypeCheckException(Locus _locus, String msg) {
        super(msg);
        locus = _locus;
    }

    public TypeCheckException(Locus _locus, String msg, Throwable ex) {
        super(msg, ex);
        locus = _locus;
    }

    public Locus getLocus() {
        return locus;
    }

}
