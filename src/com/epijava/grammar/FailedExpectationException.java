package com.epijava.grammar;

import com.epijava.util.*;

/**
 * 
 *
 */
public class FailedExpectationException extends GrammarParseException {

    private static final long serialVersionUID = 1L;

    public FailedExpectationException(Locus locus, Grammar wanted, Object got) {
        super (null);
         throw new AssertionError("Not implemented");
    }

}
