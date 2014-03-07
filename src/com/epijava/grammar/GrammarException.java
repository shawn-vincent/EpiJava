/*
 * 
 */
package com.epijava.grammar;

/**
 * Base class for exceptions thrown by grammars.
 *
 */
public class GrammarException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GrammarException() {}

    public GrammarException(String msg) { super(msg); }

    public GrammarException(String msg, Throwable ex) { super(msg, ex); }
}
