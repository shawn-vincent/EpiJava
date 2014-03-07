/*
 * 
 */
package com.epijava.lang.tree;

import java.util.ArrayList;
import java.util.List;

import com.epijava.util.*;

/**
 * 
 *
 */
public class Block extends Expression {

    private List<Expression> statements = new ArrayList<Expression>();
    
    /**
     * @param _locus
     */
    public Block(Locus _locus) {
        super(_locus);
    }
    
    @AstNode
    public List<Expression> getStatements() { return statements; }
    public Block add(Expression v) { statements.add(v); return this; }

}
