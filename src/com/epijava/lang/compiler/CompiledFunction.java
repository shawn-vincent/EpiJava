/*
 * 
 */
package com.epijava.lang.compiler;

import com.epijava.lang.tree.*;
import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class CompiledFunction extends Function {

    private final EpiCompiler compiler;
    private final CompiledType enclosingType;
    private final MethodDeclaration declaration;
    
    public CompiledFunction(EpiCompiler _compiler, CompiledType _enclosingType,
            MethodDeclaration _declaration) {
        super(_enclosingType);
        compiler = _compiler;
        enclosingType = _enclosingType;
        declaration = _declaration;
    }

    @Override
    public JavaName<? extends Definition> getName() {
        return declaration.getJavaName();
    }

    @Override
    public FunctionType getType() {
        return functionType.get();
    }
    
    private final LazyProperty<FunctionType> functionType = new LazyProperty<FunctionType>() {
        @Override
        protected FunctionType loadValue() {
            return compiler.computeType(CompiledFunction.this);
        }
    };

    public EpiCompiler getCompiler() {
        return compiler;
    }

    public CompiledType getEnclosingType() {
        return enclosingType;
    }

    public MethodDeclaration getDeclaration() {
        return declaration;
    }

    public LazyProperty<FunctionType> getFunctionType() {
        return functionType;
    }
        

}
