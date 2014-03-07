/*
 * 
 */
package com.epijava.lang.tree;

import java.util.*;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class BlockMember extends MemberDeclaration<Var> {

    private final boolean isStatic;
    private final Block statement;
    
    public BlockMember(Locus _locus, boolean _isStatic, Block _statement) {
        super(_locus, null); // XXX null name?
        isStatic = _isStatic;
        statement = _statement;
    }
    
    @AstValue
    public boolean isStatic() { return isStatic; }
    
    @AstNode
    public Block getStatement() { return statement; }

    /**
     * Convenience method: return the list of statements contained in our BlockStatement.
     * 
     * <p>Exactly equivalent to getStatement().getStatements().
     * 
     */
    public List<Expression> getStatements() {
        return getStatement().getStatements();
    }

    @Override
    public JavaNamespace<Var> getNamespace() {
        return com.epijava.lang.type.JavaNamespace.Var; // XXX this is kindof weird.  Nothing is appropriate here.
    }

}
