/*
 *
 *
 */
package com.epijava.util;

import java.util.*;

/**
 * 
 **/
public class ReflectUtil {

    public static List<Class<?>> getAllImplementedClasses(Class<?> c) {
	List<Class<?>> r = new ArrayList<Class<?>>();

	addRelatedClasses(c, r);

	return r;
    }

    private static void addRelatedClasses(Class<?> c, List<Class<?>> r) {

	Class<?> s = c.getSuperclass();
	if (s != null) {
	    r.add(s);
	    addRelatedClasses(s, r);
	}

	for (Class<?> i : c.getInterfaces()) {
	    r.add(i);
	    addRelatedClasses(i, r);
	}
    }

}