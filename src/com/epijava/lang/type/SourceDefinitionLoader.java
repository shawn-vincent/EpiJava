/*
 * 
 */
package com.epijava.lang.type;

import com.epijava.lang.*;
import com.epijava.lang.compiler.*;


/**
 * Loads types from source code, using a compiler.
 * 
 * <p>
 * XXX kindof type specific. Maybe it would be nice to allow this guy to load
 * any sort of definition? For Java (and EpiJava) we only want Types, but maybe
 * for other languages, we'd like other top level things?
 * 
 */
public class SourceDefinitionLoader extends DefinitionLoader {

    private final SourceLoader sourceLoader;
    private final EpiCompiler compiler;
    
    public SourceDefinitionLoader(DefinitionLoader _parentLoader, SourceLoader _sourceLoader, EpiCompiler _compiler) {
        super(_parentLoader);
        sourceLoader = _sourceLoader;
        compiler = _compiler;
    }
    
    public SourceDefinitionLoader(SourceLoader _sourceLoader, EpiCompiler _compiler) {
        this(SystemDefinitionLoader.getInstance(), _sourceLoader, _compiler);
    }
    
    @Override
    protected Type loadType(final JavaName<Type> typeName) {
        SourceFile file = sourceLoader.loadSource(typeName);
        
        if (file == null)
            return null;
        
        Type t = compiler.compile(this, file);
        if (t == null) 
            throw new EpiRuntimeException("XXX - huh?");
        if (!t.getName().equals(typeName))
            throw new EpiRuntimeException("XXX - main type in file for "+typeName+" had unexpected name "+t.getName());
        return t;
    }

    public void addCompiledType(CompiledType compiledType) {
        addDefinition(compiledType.getName(), compiledType);
    }

}
