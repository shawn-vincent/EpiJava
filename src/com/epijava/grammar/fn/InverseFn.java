/*
 * 
 */
package com.epijava.grammar.fn;

import java.util.*;

import com.epijava.grammar.*;

/**
 * 
 *
 */
public class InverseFn<I,O> extends GrammarFn<I,O> {
    
    private final GrammarFn<O,I> fn;
    
    public InverseFn(GrammarFn<O,I> _fn) { fn = _fn; }

    @Override
    public GrammarFn<O,I> inverse() {
        return fn;
    }
    
    @Override
    public O invoke(I in, Map<String,Object> scope) {
        return fn.invokeReverse(in, scope);
    }

    @Override
    public I invokeReverse(O in, Map<String,Object> scope) {
        return fn.invoke(in, scope);
    }

    
    public Grammar getSourceGrammar(Grammar targetGrammar)
    { return fn.getTargetGrammar(targetGrammar); }
    public Grammar getTargetGrammar(Grammar sourceGrammar)
    { return fn.getSourceGrammar(sourceGrammar); }

}
