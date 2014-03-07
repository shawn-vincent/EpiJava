/*
 * 
 */
package com.epijava.grammar.packrat;

import com.epijava.grammar.*;

/**
 * 
 * 
 */
public class LR {

    private ParseResult seed;
    private Grammar rule;
    private Head head;
    
    public LR(ParseResult seed, Grammar grammar, Head head) {
        super();
        this.seed = seed;
        this.rule = grammar;
        this.head = head;
    }

    public ParseResult getSeed() {
        return seed;
    }

    public void setSeed(ParseResult seed) {
        this.seed = seed;
    }

    public Grammar getRule() {
        return rule;
    }

    public void setRule(Grammar grammar) {
        this.rule = grammar;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    
}
