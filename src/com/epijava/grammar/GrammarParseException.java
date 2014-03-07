/*
 * 
 */
package com.epijava.grammar;

import com.epijava.grammar.packrat.*;


/**
 * 
 *
 */
public class GrammarParseException extends GrammarException {

    private final ParseFailure error;
    
    private static final long serialVersionUID = 1L;

    public GrammarParseException(ParseFailure _error) {
        super();
        error = _error;
    }

    public GrammarParseException(String msg, ParseFailure _error) {
        super(msg);
        error = _error;
    }
    
    public ParseFailure getError() { return error; }
}
