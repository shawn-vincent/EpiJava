/*
 *
 *
 */
package com.epijava.lang.tree;

import java.util.ArrayList;
import java.util.List;

import com.epijava.util.*;

public class CompilationUnit extends Expression {

    private List<Annotation> annotations = new ArrayList<Annotation>();
    private QualifiedName packageName = null;
    private List<Import> imports = new ArrayList<Import>();
    private List<TypeDeclaration> types = new ArrayList<TypeDeclaration>();
    
    /**
     * Java extension: top level statements in a compilation unit.
     */
    private Block topLevelStatements = null;

    public CompilationUnit(Locus _locus) {
        super(_locus);
    }

    @AstNode
    public List<Annotation> getAnnotations() { return annotations; }
    public CompilationUnit setAnnotations(List<Annotation> v) {
        annotations = v;
        return this;
    }

    @AstValue
    public QualifiedName getPackageName() { return packageName; }
    public CompilationUnit setPackageName(QualifiedName v) {
        packageName = v;
        return this;
    }

    @AstNode
    public List<Import> getImports() { return imports; }
    public CompilationUnit setImports(List<Import> v) {
        imports = v;
        return this;
    }

    @AstNode
    public List<TypeDeclaration> getTypes() { return types; }
    public CompilationUnit addTypes(List<TypeDeclaration> v) {
        types.addAll(v);
        return this;
    }

    @AstNode
    public Block getTopLevelStatements() {
        return topLevelStatements;
    }
    public CompilationUnit setTopLevelStatements(Block v) {
        topLevelStatements = v;
        return this;
    }
    /**
     * Convenience method: add one or more statement objects directly to the top level statements object in this class.
     */
    public CompilationUnit addTopLevelStatement(Expression... statement) {
        
        if (statement.length == 0)
            return this; // nothing to add
        
        // initialize the statement if not there: use the locus of the first
        // statement added
        if (topLevelStatements == null)
            topLevelStatements = new Block(statement[0]);
        
        // add the statements
        for (Expression n: statement)
            topLevelStatements.add(n);
        
        return this;
    }

}