/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

/**
 * 
 *
 */
public abstract class Parser {
    
    protected final Grammar grammar;

    public Parser(Grammar _grammar) {
        grammar = _grammar;
    }

    public Object parse(final String input) throws GrammarParseException {
        return parse(ObjectStream.make(input));
    }
    
    public Object parse(final Object input) throws GrammarParseException {
        if (input instanceof List)
            return parse((List<?>)input);
        else
            return parse(Collections.singletonList(input));
    }
    
    public Object parse(final Object... input) throws GrammarParseException {
        return parse(Arrays.asList(input));
    }
    
    public Object parse(final List<?> input) throws GrammarParseException {
        return parse(ObjectStream.make(input));
    }
    
    public abstract <T> Object parse(ObjectStream<T> in) throws GrammarParseException;

}
