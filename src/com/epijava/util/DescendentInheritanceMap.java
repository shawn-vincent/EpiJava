/*
 *
 *
 */
package com.epijava.util;

import java.util.*;

/**
 *
 **/
public class DescendentInheritanceMap<T> implements Map<Class<?>, T> {

    private final Map<Class<?>, T> classToValue = new HashMap<Class<?>, T>();

    public DescendentInheritanceMap() {}

    public T put(Class<?> key, T value) {

	// go up supertypes and interfaces, and put the value everywhere.
	for (Class<?> c : ReflectUtil.getAllImplementedClasses(key))
	    classToValue.put(c, value);

	// XXX this is broken.  sometimes we want to overwrite something, sometimes not...

	return classToValue.put(key, value);
    }

    /**
     * Retrieve the value associated with the given class.
     *
     * If the value is present for any subclass of 'key' (if key is a
     * class), or any class implemented by 'key' (if key is an
     * interface), the corresponding value is returned.
     **/
    public T get(Object _key) {
	if (!(_key instanceof Class))
	    return null;

	return classToValue.get(_key);
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