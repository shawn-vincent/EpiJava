/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class MethodDeclaration extends MemberDeclaration<Function> {

    private FunctionTypeReference functionType;

    public MethodDeclaration(Locus _locus, String _name) {
        super(_locus, _name);
    }

    @Override
    public JavaNamespace<Function> getNamespace() {
        return com.epijava.lang.type.JavaNamespace.Function;
    }

    public FunctionTypeReference getFunctionType() {
        return functionType;
    }

    public MethodDeclaration setFunctionType(FunctionTypeReference functionType) {
        this.functionType = functionType;
        return this;
    }


}
