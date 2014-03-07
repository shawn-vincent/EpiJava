/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 * 
 * 
 */
public class JavaNamespace<T extends Definition> {

    private final Class<T> definitionClass;

    public JavaNamespace(Class<T> _definitionClass) {
        definitionClass = _definitionClass;
    }
    
    public T cast(Definition v) {
        return definitionClass.cast(v);
    }

    public static Package Package = new Package();

    public static class Package extends JavaNamespace<com.epijava.lang.type.Package> {
        private Package() {
            super(com.epijava.lang.type.Package.class);
        }
        
        public String toString() { return "package"; }
    }

    public static Type Type = new Type();

    public static class Type extends JavaNamespace<com.epijava.lang.type.Type> {
        private Type() {
            super(com.epijava.lang.type.Type.class);
        }
        
        public String toString() { return "type"; }
    }

    public static Function Function = new Function();

    public static class Function extends
            JavaNamespace<com.epijava.lang.type.Function> {
        private Function() {
            super(com.epijava.lang.type.Function.class);
        }
        
        public String toString() { return "function"; }
    }

    public static Var Var = new Var();

    public static class Var extends JavaNamespace<com.epijava.lang.type.Var> {
        private Var() {
            super(com.epijava.lang.type.Var.class);
        }
        
        public String toString() { return "var"; }
    }

}