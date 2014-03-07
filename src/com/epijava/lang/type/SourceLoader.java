/*
 * 
 */
package com.epijava.lang.type;


/**
 * A simple interface for any class that can find source code for a type
 *
 */
public interface SourceLoader {

    public SourceFile loadSource(JavaName<Type> typeName);
    
}
