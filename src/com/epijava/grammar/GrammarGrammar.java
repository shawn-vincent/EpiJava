/*
 * 
 */
package com.epijava.grammar;

import com.epijava.util.*;

/**
 * A grammar for the grammar language itself.
 *
 */
public class GrammarGrammar extends UserGrammar {

    public Grammar main() {
        return or().rule("main");
    }
    
    
    public Grammar or() {
        // XXX should recurse on LHS instead
        return (seq().label("LHS").seq(optS()).seq(ch('/')).seq(optS()).seq(recurse("or").label("RHS")))
            .wrap(obj(OrGrammar.class, prop("lhs", 0, ref("LHS")), prop("rhs", 1, ref("RHS"))))
        .or(seq())
        .rule("or");
    }
    
    public Grammar seq() {
        // XXX should recurse on LHS instead
        return (terminal().label("LHS").seq(S()).seq(recurse("seq").label("RHS")))
            .wrap(obj(SeqGrammar.class, prop("lhs", 0, ref("LHS")), prop("rhs", 1, ref("RHS"))))
        .or(terminal())
        .rule("seq");
    }


    public Grammar terminal() {
        return character().or(parenthesized()).or(nullG());
    }

    private Grammar parenthesized() {
        return ch('(').seq(recurse("main").label("G")).seq(ch(')')).wrap(ref("G"))
        .rule("paren");
    }

    public Grammar character() {
        // XXX escape sequences
        return ch('\'').seq(obj(CodePoint.class).label("V")).seq(ch('\''))
        .wrap(obj(ConstantGrammar.class, prop("value", 0, ref("V"))))
        .rule("char");
    }
    
    public Grammar nullG() {
        return str("null")
        .wrap(obj(ConstantGrammar.class, prop("value", 0, constant(null))))
        .rule("null");
    }
    

}
