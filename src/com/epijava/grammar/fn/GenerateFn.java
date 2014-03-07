/*
 * 
 */
package com.epijava.grammar.fn;

import java.util.*;

import com.epijava.grammar.*;
import com.epijava.grammar.Grammar.*;

/**
 * 
 *
 */
public class GenerateFn extends GrammarFn<Object,Object> {
    
    private final Grammar src;
    private final Grammar target;
    
    public GenerateFn(Grammar _src, Grammar _target) {
        src = _src; target = _target;
    }
    
    @Override
    public GenerateFn inverse() {
        InverseScope scope = new InverseScope();
        final Grammar sourceInverse = src.inverse(scope);
        final Grammar targetInverse = target.inverse(scope);
        return new GenerateFn(targetInverse, sourceInverse);
    }

    @Override
    public Grammar getSourceGrammar(Grammar targetGrammar) {
        return src;
    }

    @Override
    public Grammar getTargetGrammar(Grammar sourceGrammar) {
        return target;
    }

    @Override
    public Object invoke(Object in, Map<String,Object> scope) {
        return target.generator(scope).generate();
    }

    @Override
    public Object invokeReverse(Object in, Map<String,Object> scope) {
        // XXX this is never called currently, and wouldn't work. (we don't have the labels, refs worked out??)
        return src.inverse().generator(scope).generate();
    }

}
