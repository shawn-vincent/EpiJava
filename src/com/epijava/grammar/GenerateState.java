/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

import com.epijava.grammar.Grammar.*;

/**
 * 
 *
 */
public class GenerateState {
    
    private final Map<String,Object> scope;
    private Map<String,Grammar> enclosingRules = new HashMap<String,Grammar>();
    private final OrGenerator orGenerator;

    GenerateState(Map<String,Object> _scope, OrGenerator _orGenerator) {
        scope = _scope; orGenerator = _orGenerator;
    }

    public Object getScopeValue(String name) {
        return scope.get(name);
    }

    public boolean hasScopeValue(String name) {
        return scope.containsKey(name);
    }

    public OrGenerator getOrGenerator() {
        return orGenerator;
    }

    public GenerateState addRule(RuleGrammar grammarRule) {
        GenerateState r = new GenerateState(scope, orGenerator);
        r.enclosingRules = new HashMap<String,Grammar>(enclosingRules);
        r.enclosingRules.put(grammarRule.getName(), grammarRule);
        return r;
    }

    public Grammar getEnclosingRule(String ruleName) {
        return enclosingRules.get(ruleName);
    }

}
