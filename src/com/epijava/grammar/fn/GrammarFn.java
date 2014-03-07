/*
 * 
 */
package com.epijava.grammar.fn;

import java.util.*;

import com.epijava.grammar.*;

/**
 * 
 * 
 *
 */
public abstract class GrammarFn<I,O> {
    public GrammarFn<O,I> inverse() {
        return new InverseFn<O,I>(this);
    }
    
    public abstract O invoke(I in, Map<String,Object> scope);
    
    public abstract I invokeReverse(O in, Map<String,Object> scope);
    
    
    public abstract Grammar getSourceGrammar(Grammar targetGrammar);
    public abstract Grammar getTargetGrammar(Grammar sourceGrammar);
}
