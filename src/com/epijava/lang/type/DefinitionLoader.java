/*
 * 
 */
package com.epijava.lang.type;

import java.util.*;

/**
 * An EpiJava analog to ClassLoader - loads Definitions, which may correspond to
 * interpreted Java compilation units or compiled Java classes accessed through
 * reflection
 * 
 */
public abstract class DefinitionLoader implements JavaScope {

    private final DefinitionLoader parentLoader;
    
    /**
     * Cached types, so that the same type is always returned for a given name.
     */
    private Map<JavaName<?>,Definition> cachedDefinitions = new HashMap<JavaName<?>,Definition>();
    
    public DefinitionLoader(DefinitionLoader _parentTypeLoader) {
        parentLoader = _parentTypeLoader;
    }
    
    public <T extends Definition> T getDefinition(JavaName<T> name) {
        T r = name.cast(cachedDefinitions.get(name));
        if (r != null)
            return r;
        
        r = loadDefinition(name);
        if (r != null) {
            addDefinition(name, r);
            return r;
        }
        
        if (parentLoader != null) {
            r = parentLoader.getDefinition(name);
            if (r != null) {
                // do not add to our cache: it's from our parent's cache.
                return r;
            }
        }
        
        return null;
    }
    
    protected <T extends Definition> void addDefinition(JavaName<T> name, T definition) {
        verifyDefinition(name, definition);
        cachedDefinitions.put(name, definition);
    }
    
    protected <T extends Definition> void verifyDefinition(JavaName<T> name, T v) {
        if (!v.getName().equals(name))
            throw new AssertionError("XXX bad name");
    }
    


    protected <T extends Definition> T loadDefinition(JavaName<T> name) {

        if (name.isTypeName())
            return name.cast(loadType(name.toTypeName()));

        if (name.isPackageName())
            return name.cast(loadPackage(name.toPackageName()));

        if (parentLoader != null)
            return parentLoader.getDefinition(name);

        return null;
    }
    
    protected Package loadPackage(JavaName<Package> name) {
        return new Package(this, name);
    }

    protected abstract Type loadType(JavaName<Type> name);
}
