/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * Abstract base class of all EpiJava syntax tree nodes.
 * 
 * <p>
 * Can represent a Java expression, statement, declaration, or anything else
 * (compilation units, imports, etc)
 * 
 * <p>
 * 'Expression' is used here mostly because most of the subclasses are
 * expressions, and the term 'expression' can be considered 'an expression of a
 * programmer's intent' for all of these concepts.
 * 
 * <p>
 * Plus, I couldn't come up with a better name. :-)
 * 
 */
public abstract class Expression implements Locus {

    /**
     * The locus: the location in the source code (file/line) where this
     * expression occurs
     */
    private final Locus locus;

    /**
     * Set by typechecker
     */
    private Type type = null;

    /**
     * Create a new Expression, given a locus.
     * 
     * <p>
     * If the locus is NULL, defaults to the unknown locus {@link Locus#Unknown}
     */
    public Expression(Locus _locus) {
        if (_locus == null)
            _locus = Locus.Unknown;
        locus = _locus;
    }

    /**
     * Set the result type of this expression.
     * 
     * <p>Called by the typechecker.
     */
    public Expression setType(Type t) {
        type = t;
        return this;
    }

    /**
     * Fetch the result type of this expression.
     * 
     * <p>
     * If the typechecker has not yet been run, this will return NULL.
     */
    public Type getType() {
        return type;
    }

    /**
     * Return the filename in which this expression occurs.
     * 
     * <p>
     * Implementation of the Locus interface.
     */
    public String locusModule() {
        return locus.locusModule();
    }

    /**
     * Return the line number in which this expresion occurs.
     * 
     * <p>
     * Implementation of the locus interface
     */
    public int locusPosition() {
        return locus.locusPosition();
    }

}
