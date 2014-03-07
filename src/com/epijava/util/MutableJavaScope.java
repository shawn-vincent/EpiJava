/*
 * 
 */
package com.epijava.util;

import java.util.*;

import com.epijava.lang.type.*;

/**
 * A simple mutable implementation of a Java scope.
 * 
 */
public class MutableJavaScope implements JavaScope {

    private final JavaScope parentScope;

    private final Map<JavaName<?>, Definition> names = new LinkedHashMap<JavaName<?>, Definition>();

    public MutableJavaScope() {
        this(new EmptyScope());
    }

    public MutableJavaScope(JavaScope _parentScope) {
        parentScope = _parentScope;
    }

    public <T extends Definition> T getDefinition(JavaName<T> name) {
        if (names.containsKey(name))
            return name.cast(names.get(name));

        if (parentScope != null)
            return parentScope.getDefinition(name);

        return null;
    }
    
    public MutableJavaScope addDefinition(Definition value) {
        names.put(value.getName(), value);
        return this;
    }

}
