/*
 * 
 */
package com.epijava.util.unify;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the result of a unification.
 * 
 * <p>A simple Map interface.
 *
 */
public class UnifyBindings {
    
    private final Map<String,Object> bindings = new HashMap<String,Object>();

    public boolean hasBinding(String name) {
        return bindings.containsKey(name);
    }
    
    public Object get(String name) {
        return bindings.get(name);
    }

    public void put(String name, Object o) {
        bindings.put(name, o);
    }

}
