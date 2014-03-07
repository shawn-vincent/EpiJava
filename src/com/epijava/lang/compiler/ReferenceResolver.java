/*
 * 
 */
package com.epijava.lang.compiler;

import com.epijava.lang.reflect.*;
import com.epijava.lang.tree.*;
import com.epijava.lang.type.*;
import com.epijava.lang.type.Package;
import com.epijava.util.*;

/**
 * Resolves references given a scope.
 * 
 *
 */
public class ReferenceResolver {
    
    private final JavaScope scope;
    
    public ReferenceResolver(JavaScope _scope) {
        scope = _scope;
    }

    /**
     * Main entry point: resolve a reference to a Definition.
     * 
     * <p>
     * Also updates the given reference with the resolved definition.
     * 
     * <p>
     * As a performance improvement, returns the stored definition if it is
     * available.
     */
    @SuppressWarnings("unchecked")
    public <T extends Definition> T resolve(Reference<T> ref) {
        
        if (ref.getDefinition() != null)
            return ref.getDefinition();
        
        T r = (T)resolveMM.invoke(this, ref);
        ref.setDefinition(r);
        
        return r;
    }
    
    private static final Multimethod resolveMM = 
        Multimethod.create(SimpleType.make(ReferenceResolver.class), "resolve_", 1);
    
    public <T extends Definition> T resolve_(Reference<T> v) {
        throw new UnsupportedOperationException(
                "Cannot resolve reference of type "+v.getClass().getName());
    }

    
    public Package resolve_(PackageReference v) {
        Package r = scope.getDefinition(v.getPackageName());
        
        if (r == null)
            throw new RuntimeException("Can't resolve "+v+": can't find package");
        
        return r;
    }
    
    public Type resolve_(NamedTypeReference v) {

        JavaScope scope;
        Reference<? extends Definition> scopeRef = v.getScope();
        if (scopeRef == null)
            scope = this.scope;
        else
            scope = (JavaScope) resolve(scopeRef);

        JavaName<Type> name = JavaName.type(v.getName());
        Type r = scope.getDefinition(name);
        if (r == null)
            throw new RuntimeException("XXX can't resolve " + v
                    + ": can't find type " + name + " in scope " + scope);
        return r;
    }

    public Definition resolve_(PackageOrTypeReference v) {
        return resolve(reclassifyPackageOrTypeName(v));
    }

    public Definition resolve_(AmbiguousReference v) {
        return resolve(reclassifyAmbiguousName(v));
    }
    
    public Type resolve_(FunctionTypeReference v) {
        Type returnType = resolve(v.getReturnType());
        
        // XXX resolve parameter types, exception types
        
        return new FunctionType(null, returnType, null);
    }
    
    
    public Reference<? extends Definition> reclassifyPackageOrTypeName(
            PackageOrTypeReference ref) {

        if (ref.isSimpleName()) {
            String simpleName = ref.getName();

            Type t = scope.getDefinition(JavaName.type(simpleName));
            if (t != null)
                return new NamedTypeReference(ref, null, simpleName)
                        .setDefinition(t);

            Package p = scope.getDefinition(JavaName.pkg(simpleName));
            if (p != null)
                return new PackageReference(ref, simpleName).setDefinition(p);

            throw new AssertionError("PackageOrTypeName " + ref
                    + " did not resolve to type or package!?");
        } else {

            Reference<? extends Definition> lhs = reclassifyPackageOrTypeName(ref
                    .getScope());
            String rhs = ref.getName();

            if (lhs instanceof PackageReference) {
                
                PackageReference pkgRef = (PackageReference)lhs;

                JavaScope packageScope = (JavaScope) lhs.getDefinition();

                Type t = packageScope.getDefinition(JavaName.type(rhs));
                if (t != null)
                    return new NamedTypeReference(ref, (PackageReference) lhs,
                            rhs).setDefinition(t);

                Package p = packageScope.getDefinition(JavaName.pkg(pkgRef.getPackageName().getName() + "." + rhs));
                
                if (p != null)
                    return new PackageReference((Locus) ref,
                            (PackageReference) lhs, rhs).setDefinition(p);

                throw new AssertionError("PackageOrTypeName " + ref
                        + " did not resolve to type or package!?");

            } else if (lhs instanceof TypeReference) {

                Type enclosingType = ((TypeReference) lhs).getDefinition();

                // XXX we need the type here of the declaration to do this
                // stuff...maybe?

                // XXX yes. If it's a var reference, then... yeah.

                // XXX oh, but we do have it. Both the type AND the declaration.
                // All the way down.
                //
                // XXX this is odd: for ExprReference, Eclipse (at least) seems
                // not to allow this.
                Type nestedType = enclosingType.getDefinition(JavaName
                        .type(rhs));
                if (nestedType != null)
                    return new NamedTypeReference(ref, (TypeReference) lhs, rhs)
                            .setDefinition(nestedType);

                throw new TypeCheckException(ref,
                        "Could not find nested type named " + rhs + " in "
                                + enclosingType);
            }

            throw new AssertionError("PackageOrTypeName " + lhs
                    + " did not resolve to PackageName or TypeName!?");
        }

    }

    
    /**
     * Implements the algorithm found in JLS 3rd edition - 6.5.2
     * Reclassification of Contextually Ambiguous Names
     */
    public Reference<? extends Definition> reclassifyAmbiguousName(
            AmbiguousReference ref) {

        return reclassifyAmbiguousName(ref.getName());
    }

    public Reference<? extends Definition> reclassifyAmbiguousName(
            QualifiedName name) {

        if (name.isSimpleName()) {
            String simpleName = name.last();

            // deals with local variables, parameters, fields, static imports,
            Var v = scope.getDefinition(JavaName.var(simpleName));
            if (v != null)
                return new VarReference(name, simpleName).setDefinition(v);

            Type t = scope.getDefinition(JavaName.type(simpleName));
            if (t != null)
                return new NamedTypeReference(name, null, simpleName)
                        .setDefinition(t);

            return new PackageReference(name, simpleName);
        } else {

            Reference<? extends Definition> lhs = reclassifyAmbiguousName(name
                    .allButLast());
            String rhs = name.last();

            if (lhs instanceof PackageReference) {
                String qualifiedTypeName = lhs.toString() + "." + rhs;
                Type t = scope.getDefinition(JavaName.type(qualifiedTypeName));
                if (t != null)
                    return new NamedTypeReference(name, (PackageReference) lhs,
                            rhs).setDefinition(t);
                else
                    return new PackageReference((Locus) name,
                            (PackageReference) lhs, rhs);
            }

            if (lhs instanceof TypeReference) {

                Type selfDeclaration = ((TypeReference) lhs).getDefinition();

                // XXX we need the type here of the declaration to do this
                // stuff...maybe?

                // XXX yes. If it's a var reference, then... yeah.

                // XXX oh, but we do have it. Both the type AND the declaration.
                // All the way down.
                //
                // XXX this doesn't work yet.
                Var fieldDeclaration = selfDeclaration.getDefinition(JavaName
                        .var(rhs));
                if (fieldDeclaration != null)
                    return new FieldReference(name, lhs, rhs)
                            .setDefinition(fieldDeclaration);

                // XXX this is odd: for ExprReference, Eclipse (at least) seems
                // not to allow this.
                Type nestedDeclaration = selfDeclaration.getDefinition(JavaName
                        .type(rhs));
                if (nestedDeclaration != null)
                    return new NamedTypeReference(name, (TypeReference) lhs,
                            rhs).setDefinition(nestedDeclaration);

                throw new TypeCheckException(name,
                        "Could not find field or nested type named " + rhs
                                + " in " + selfDeclaration);
            }

            if (lhs instanceof ExprReference) {
                throw new UnsupportedOperationException();
            }

            throw new AssertionError(
                    "LHS of ambiguous name did not resolve to PackageName, TypeName, or ExprName!?");
        }

    }


}
