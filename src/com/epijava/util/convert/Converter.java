/*
 *
 *
 */
package com.epijava.util.convert;

import com.epijava.util.*;

/**
 * Converts values from one type to another.
 **/
public class Converter {

    private final Converter parent;

    private final DescendentInheritanceMap<AncestorInheritanceMap<ConverterFn<?,?>>> 
	fnsByToThenByFrom =
	new DescendentInheritanceMap<AncestorInheritanceMap<ConverterFn<?, ?>>>();

    public Converter() { this(null); }
    public Converter(Converter _parent) { parent = _parent; }

    public Converter install(ConverterFn<?,?> fn) {
	AncestorInheritanceMap<ConverterFn<?,?>> fnsByFrom = getFnsByFrom(fn.getTo(), true);

	fnsByFrom.put(fn.getFrom(), fn);

	return this;
    }

    @SuppressWarnings("unchecked")
    public <F,T> ConverterFn<F,T> getConverterFn(Class<F> from, Class<T> to) {
	AncestorInheritanceMap<ConverterFn<?,?>> fnsByFrom = getFnsByFrom(to, false);

	if (fnsByFrom == null) return null;

	return (ConverterFn<F,T>)fnsByFrom.get(from);
    }
    
    public boolean canConvert(Object v, Class<?> toType) {
	return getConverterFn(v.getClass(), toType) != null;
    }

    public <F,T> T convert(F v, Class<T> toType) {
	// XXX broken: the cast here is unsafe: something wrong with the converter generics...
        @SuppressWarnings("unchecked")
        ConverterFn<F,T> fn = getConverterFn((Class<F>)v.getClass(), toType);
        return fn.convert(v);
    }

    private AncestorInheritanceMap<ConverterFn<?,?>> getFnsByFrom(Class<?> to, boolean create) {
	AncestorInheritanceMap<ConverterFn<?,?>> r =
	    fnsByToThenByFrom.get(to);
	if (create && r == null) {
	    r = new AncestorInheritanceMap<ConverterFn<?,?>>();
	    fnsByToThenByFrom.put(to, r);
	}

	return r;
    }
}