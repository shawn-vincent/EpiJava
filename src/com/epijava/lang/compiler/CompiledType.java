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
public class CompiledType extends Type {
    
    private final DefinitionLoader loader;
    
    private final EpiCompiler compiler;
    
    private final TypeDeclaration typeDeclaration;
    
    private final JavaName<Type> typeName;
    
    public CompiledType(DefinitionLoader _loader, EpiCompiler _compiler,
            Type _enclosingType,
            TypeDeclaration _typeDeclaration, JavaName<Type> _typeName) {
        super(_enclosingType);
        
        if (_loader == null || _compiler == null || _typeDeclaration == null
                || _typeName == null)
            throw new NullPointerException();

        loader = _loader;
        compiler = _compiler;
        typeDeclaration = _typeDeclaration;
        typeName = _typeName;
    }

    @Override
    public JavaName<Type> getName() {
        return typeName;
    }
    
    public TypeDeclaration getTypeDeclaration() { return typeDeclaration; }
    
    @Override
    public <T extends Definition> T getDefinition(JavaName<T> name) {
        return getDefinitionScope().getDefinition(name);
    }

    private final LazyProperty<JavaScope> definitionScope = new LazyProperty<JavaScope>() {
        @Override
        protected JavaScope loadValue() {
            return getDefinitionScope_();
        }};
        
    private JavaScope getDefinitionScope() {
        return definitionScope.get();
    }
    
    private JavaScope getDefinitionScope_() {
        return compiler.makeTopLevelScope(this);
    }

    public DefinitionLoader getDefinitionLoader() {
        return loader;
    }


}
