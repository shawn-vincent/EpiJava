/*
 *
 *
 */
package com.epijava.lang.print;

import java.io.PrintWriter;
import java.util.List;

import com.epijava.lang.reflect.*;
import com.epijava.lang.tree.*;
import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * A visitor that prints java expressions
 **/
public class EpiPrinter {
    
    private final PrintWriter out;
    
    public EpiPrinter(PrintWriter _out) { out = _out; }
    
    public void printAll(List<? extends Expression> v) {
        for (Expression node : v)
            print(node);
    }
    
    public void print(Expression v) {
        PrintMethod.invoke(this, v);
    }
    private static final Multimethod PrintMethod = Multimethod.create(SimpleType.make(EpiPrinter.class), "print_", 1);
    
    // -------------------------------------------------------------------------
    
    public void print_(Expression v) {
        throw new EpiPrintException("Could not print "+v.getClass().getName());
    }
    
    public void print_(CompilationUnit v) {
        printAnnotations(v.getAnnotations());
        printPackageDeclaration(v.getPackageName());
        printAll(v.getImports());
        printAll(v.getTypes());
    }
    
    public void print_(Import v) {
        printKeyword("import");
        if (v.isStaticImport()) {
            printSpace();
            printKeyword("static");
        }
        
        printSpace();
        printQualifiedName(v.getName());
        
        if (v.isImportAll()) {
            printDot();
            printStar();
        }
        
        printSemicolon();
        println();
    }
    
    public void print_(ClassDeclaration v) {
        // XXX modifiers
        printKeyword("class");
        printSpace();
        printIdentifier(v.getName());
        
        if (v.getSuperType() != null) {
            printSpace();
            printKeyword("extends");
            printSpace();
            print(v.getSuperType());
        }
        
        if (!v.getInterfaces().isEmpty()) {
            printSpace();
            printKeyword("implements");
            printSpace();
            boolean first = true;
            for (TypeReference i : v.getInterfaces()) {
                if (first) first = false;
                else printComma();
                print(i);
            }
        }
        
        beginBlock();
        
        for (MemberDeclaration<?> m : v.getMembers())
            print(m);
        
        endBlock();
    }

    // -------------------------------------------------------------------------

    private void printPackageDeclaration(QualifiedName packageName) {
        printKeyword("package");
        printSpace();
        printQualifiedName(packageName);
        printSemicolon();
        println();
    }

    private void printAnnotations(List<Annotation> annotations) {
        for (Annotation annotation: annotations) print(annotation);
    }
    
     
    private void printQualifiedName(QualifiedName name) {
        boolean first = true;
        for (String s : name.getComponents()) {
            if (first) first = false;
            else printDot();
            printIdentifier(s);
        }
    }
    
    // ------------------------------------------------------------------------
    
    private void beginBlock() {
        out.println();
        out.println('{');
    }
    
    private void endBlock() {
        out.println();
        out.println('}');
    }
    
    // ------------------------------------------------------------------------
    
    private void println() {
        out.println();
    }
    
    private void printKeyword(String keyword) {
        out.print(keyword);
    }
    
    private void printIdentifier(String identifier) {
        out.print(identifier);
    }
    
    private void printSpace() {
        out.print(' ');
    }

    private void printDot() {
        out.print('.');
    }
    
    private void printComma() {
        out.print(',');
    }
    
    private void printStar() {
        out.print('*');
    }
    
    private void printSemicolon() {
        out.print(';');
    }

 
}