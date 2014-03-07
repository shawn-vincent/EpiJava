/*
 * 
 */
package com.epijava.lang.compiler;

import java.util.*;

import com.epijava.lang.*;
import com.epijava.lang.parser.*;
import com.epijava.lang.tree.*;
import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * A compiler for the EpiJava language.
 * 
 * <p>
 * EpiCompiler is stateless: it can be used by many SourceDefinitionLoaders at
 * the same time.
 * 
 * <p>
 * An EpiCompiler is a configuration of a language to compile, and a set of
 * behaviors to compile that language.
 * 
 */
public class EpiCompiler {
       
    public EpiCompiler() {
    }
    
    /**
     * Main entry point to EpiCompiler: compile a source file, and register the results with the given definition loader.
     * 
     * <p>Returns the top level type in the file.
     */
    public Type compile(SourceDefinitionLoader loader, SourceFile file) {
        
        CompilationUnit compilationUnit;
        try {
            compilationUnit = new EpiParser().parse(file.getLocusModule(), file.getReader());
        } catch (EpiParseException ex) {
            throw new EpiRuntimeException("Could not parse "+file.getLocusModule(), ex);
        }
        
        return compile(loader, compilationUnit);
    }
    
    /**
     * Alternate entry point: compile the specified parse tree, generate the
     * resulting types with the specified definition loader.
     * 
     * <p>Returns the top level type defined in the compilation unit.
     */
    public Type compile(SourceDefinitionLoader loader,
            CompilationUnit compilationUnit) {

        DefinitionLoader importLoader = loader; // XXX wrong: needs to consider
                                                // import statements.

        // XXX broken.
        List<TypeDeclaration> types = compilationUnit.getTypes();

        // XXX parentType???
        QualifiedName packageName = compilationUnit.getPackageName();

        Type topLevelType = null;
        for (TypeDeclaration type : types) {

            JavaName<Type> typeName = packageName == null ? type.getJavaName()
                    : JavaName.type(packageName.toString() + "."
                            + type.getName());

            CompiledType compiledType = new CompiledType(importLoader, this, null,
                    type, typeName);
            if (topLevelType == null)
                topLevelType = compiledType;
            loader.addCompiledType(compiledType);
        }

        return topLevelType;
    }

    /**
     * Generate a top-level scope for the given type.
     * 
     * <p>Internal: called by CompiledType.
     */
    protected JavaScope makeTopLevelScope(CompiledType type) {

        MutableJavaScope r = new MutableJavaScope(type.getDefinitionLoader());

        for (MemberDeclaration<?> declaration : type.getTypeDeclaration()
                .getMembers()) {
            
            Definition memberDefinition = makeDefinition(type, declaration);
            r.addDefinition(memberDefinition);
        }

        return r;
    }
    
    /**
     * Make a definition for the given MemberDeclaration
     */
    protected <T extends Definition> T makeDefinition(CompiledType type,
            MemberDeclaration<T> declaration) {
        JavaNamespace<T> namespace = declaration.getNamespace();

        if (namespace == JavaNamespace.Type)
            return namespace.cast(new CompiledType(type.getDefinitionLoader(),
                    this, type, (TypeDeclaration) declaration, declaration
                            .getJavaName().toTypeName()));
        
        else if (namespace == JavaNamespace.Function)
            return namespace.cast(new CompiledFunction(this, type,
                    (MethodDeclaration) declaration));
        
        else
            // XXX support field here as well.
            throw new UnsupportedOperationException("Unsupported member type: "
                    + declaration.getNamespace());
    }
    
    /**
     * Compute the FunctionType for the given CompiledFunction.
     */
    protected FunctionType computeType(CompiledFunction function) {
        MethodDeclaration declaration = function.getDeclaration();
        
        return (FunctionType)new ReferenceResolver(function.getEnclosingType().getDefinitionLoader())
                .resolve(declaration.getFunctionType());
    }
    
    

}
