/*
 * 
 */
package com.epijava.grammar;

import com.epijava.grammar.Grammar.*;

/**
 * 
 *
 */
public class GrammarVisitor<I,O> {

    public O visit(Grammar g, I _) { throw new UnsupportedOperationException(); }
    
    public O visit(EmptyGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(ConstantGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(EofGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(ObjectGrammar<?> g, I _) { return visit((Grammar)g, _); }


    public O visit(SeqGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(AndGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(OrGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(NotGrammar g, I _) { return visit((Grammar)g, _); }


    public O visit(CanonicalGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(WrapGrammar<?,?> g, I _) { return visit((Grammar)g, _); }
    

    public O visit(LabelGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(RefGrammar g, I _) { return visit((Grammar)g, _); }


    public O visit(RuleGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(RecurseGrammar g, I _) { return visit((Grammar)g, _); }

    public O visit(UserGrammar g, I _) { return visit((Grammar)g, _); }

}
