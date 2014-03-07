/*
 * 
 */
package com.epijava.lang.type;

import java.util.*;

/**
 * 
 *
 */
public class MutableDefinitionLoader extends DefinitionLoader {

    private final Map<JavaName<Type>,Type> typesByName = new HashMap<JavaName<Type>,Type>();
    
    public MutableDefinitionLoader(DefinitionLoader parent) { super (parent); }
    public MutableDefinitionLoader() { this(SystemDefinitionLoader.getInstance()); }
    
    public MutableDefinitionLoader addType(Type t) {
        typesByName.put(t.getName(), t);
        return this;
    }
    
    @Override
    protected Type loadType(JavaName<Type> name) {
        return typesByName.get(name);
    }

}
