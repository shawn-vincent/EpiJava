/*
 * 
 */
package com.epijava.lang.type;


/**
 * 
 *
 */
public class JavaName<T extends Definition> {
    private final JavaNamespace<T> namespace;
    private final String name;
    
    public JavaName(JavaNamespace<T> _namespace, String _name) 
    {
        if (_namespace == null) throw new NullPointerException();
        if (_name == null) throw new NullPointerException();
        if (_name.length() == 0) throw new IllegalArgumentException("JavaName name cannot be empty String");
        namespace = _namespace; name = _name; 
    }
    
    public static JavaName<Type> type(String name) {
        return new JavaName<Type>(JavaNamespace.Type, name);
    }

    public static JavaName<Function> function(String name) {
        return new JavaName<Function>(JavaNamespace.Function, name);
    }
    
    public static JavaName<Var> var(String name) {
        return new JavaName<Var>(JavaNamespace.Var, name);
    }
    
    public static JavaName<Package> pkg(String name) {
        return new JavaName<Package>(JavaNamespace.Package, name);
    }
    
    public JavaNamespace<T> getNamespace() { return namespace; }
    public String getName() { return name; }

    public boolean isTypeName() { return namespace == JavaNamespace.Type; }
    public boolean isVarName() { return namespace == JavaNamespace.Var; }
    public boolean isFunctionName() { return namespace == JavaNamespace.Function; }
    public boolean isPackageName() { return namespace == JavaNamespace.Package; }
    
    @SuppressWarnings("unchecked")
    public JavaName<Type> toTypeName() {
        if (namespace != JavaNamespace.Type)
            throw new ClassCastException();
        return (JavaName<Type>)this;
    }

    @SuppressWarnings("unchecked")
    public JavaName<Var> toVarName() {
        if (namespace != JavaNamespace.Var)
            throw new ClassCastException();
        return (JavaName<Var>)this;
    }
    
    @SuppressWarnings("unchecked")
    public JavaName<Function> toFunctionName() {
        if (namespace != JavaNamespace.Function)
            throw new ClassCastException();
        return (JavaName<Function>)this;
    }
    
    @SuppressWarnings("unchecked")
    public JavaName<Package> toPackageName() {
        if (namespace != JavaNamespace.Package)
            throw new ClassCastException();
        return (JavaName<Package>)this;
    }
    public T cast(Definition definition) {
        return namespace.cast(definition);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JavaName<?> other = (JavaName<?>) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (namespace == null) {
            if (other.namespace != null)
                return false;
        } else if (!namespace.equals(other.namespace))
            return false;
        return true;
    }

 
    
    public String toString() {
        return namespace + ":" + name;
    }


    
}
