/*
 * 
 */
package com.epijava.grammar;

/**
 * 
 *
 */
public class AmbiguousGrammarException extends GrammarGenerateException {

    private static final long serialVersionUID = 1L;

    public AmbiguousGrammarException() {
        super();
    }

    public AmbiguousGrammarException(final String msg) {
        super(msg);
    }

    public AmbiguousGrammarException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
