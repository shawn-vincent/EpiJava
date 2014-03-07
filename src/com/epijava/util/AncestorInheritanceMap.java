/*
 *
 *
 */
package com.epijava.util;

import java.util.*;

/**
 * Maps classes to values, respecting Java inheritance rules.
 *
 * Thus, if you do:
 *
 *     m.put(String.class, "Foo");
 *     m.put(Number.class, "Bar");
 *     m.put(Serializable.class, "Baz");
 *
 * then
 * 
 *     m.get(Integer.class) == "Bar"
 *     m.get(Object.class) == null
 *     m.get(Date.class) == "Baz"
 **/
public class AncestorInheritanceMap<T> implements Map<Class<?>, T> {

    private final Map<Class<?>, T> classToValue = new HashMap<Class<?>, T>();

    public AncestorInheritanceMap() {}

    public T put(Class<?> key, T value) {
	return classToValue.put(key, value);
    }

    /**
     * Retrieve the value associated with the given class.
     *
     * If the given key is not found, all superclasses and interfaces of the class
     * are searched
     *
     * The result could be cached??
     **/
    public T get(Object _key) {
	if (!(_key instanceof Class))
	    return null;

	Class<?> key = (Class<?>)_key;

	T r = classToValue.get(key);
	if (r != null) return r;

	// go up supertypes and interfaces, and see if anybody has the value
	for (Class<?> c : ReflectUtil.getAllImplementedClasses(key)) {
	    r = classToValue.get(c);
	    if (r != null) return r;
	}

	// doom
	return null;
    }

    public Collection<T> values() { return classToValue.values(); }
    public Set<Class<?>> keySet() { return classToValue.keySet(); }
    public Set<Entry<Class<?>,T>> entrySet() { return classToValue.entrySet(); }
    public T remove(Object key) { return classToValue.remove(key); }
    public boolean containsKey(Object key) { return classToValue.containsValue(key); }
    public boolean containsValue(Object key) { return classToValue.containsValue(key); }
    public boolean isEmpty() { return classToValue.isEmpty(); }
    public int size() { return classToValue.size(); }
    public void clear() { classToValue.clear(); }
    public void putAll(Map<? extends Class<?>, ? extends T> m) { classToValue.putAll(m); }

}