/*
 * 
 */
package com.epijava.lang.tree;

import java.util.*;

import com.epijava.util.*;

/**
 * 
 *
 */
public class Call extends Expression {
    
    private final Expression self;
    private final String methodName;
    private final List<Expression> args;

    public Call(Locus _locus, Expression _self, String _methodName, List<Expression> _args) {
        super(_locus);
        self = _self;
        methodName = _methodName;
        args = _args;
    }
    
    public Call(Locus _locus, QualifiedName _qualifiedName, List<Expression> _args) {
        super(_locus);
        
        if (_qualifiedName.isSimpleName())
            self = null;
        else
            // XXX loss of locus information here
            self = new AmbiguousReference(_locus, _qualifiedName.allButLast());
        
        methodName = _qualifiedName.last();
        args = _args;
    }
    
    public Call(Locus _locus, AmbiguousReference callNameExpr, List<Expression> _args) {
        this(_locus, callNameExpr.getName(), _args);
    }

    public Expression getSelf() {
        return self;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<Expression> getArgs() {
        return args;
    }
    
   

}
