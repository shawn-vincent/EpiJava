/*
 * 
 */
package com.epijava.lang.type;

import java.io.*;

/**
 * 
 *
 */
public class LiteralSourceLoader implements SourceLoader {
    
    private final JavaName<Type> className;
    private final String source;
    
    public LiteralSourceLoader(JavaName<Type> _className, String _source) {
        className = _className;
        source = _source;
    }
    
    // XXX autodetect the type from the source?

    public SourceFile loadSource(JavaName<Type> typeName) {
        if (!className.equals(typeName))
            return null;
        else
            return new SourceFile("<Literal for "+typeName+">", new StringReader(source));
    }

}
