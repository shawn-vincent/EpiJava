/*
 * 
 */
package com.epijava.lang.type;

import com.epijava.lang.reflect.*;

/**
 * Defines things known to everyplace in Java (fully qualified names, for
 * example)
 * 
 */
public abstract class GlobalJavaScope implements JavaScope {

    // XXX DO NOT USE

    public <T extends Definition> T getDefinition(JavaName<T> name) {
        if (name.isTypeName())
            try {
                return name.cast(SimpleType.forName(name.getName()));
            } catch (NotFoundReflectException ex) {
                return null;
            }
        else
            return null;
    }

}
