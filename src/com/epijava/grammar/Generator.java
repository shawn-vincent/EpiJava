/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

/**
 * Generates an input stream for a grammar.
 *
 */
public class Generator {

    private final Grammar grammar;
    private final Map<String,Object> scope;
    
    private OrGenerator orGenerator = new OrGenerator.Disallowed();
    
    public Generator(Grammar _grammar, Map<String,Object> _scope) 
    { grammar = _grammar; scope = _scope; }
    
    public Object generate() {
        return grammar.generate(makeBuilderState());
    }

    private GenerateState makeBuilderState() {
        return new GenerateState(scope, orGenerator);
    }
    
    public Generator setOrGenerator(OrGenerator v) { orGenerator = v; return this; }
}
