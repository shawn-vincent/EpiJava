/*
 *
 *
 */
package com.epijava.util.convert;

/**
 * Converts values from Java type 'F' to 'T'.
 **/
public abstract class ConverterFn<F,T> {
    private final Class<F> fromClass;
    private final Class<T> toClass;

    public ConverterFn(Class<F> _fromClass, Class<T> _toClass) {
	fromClass = _fromClass; toClass = _toClass;
    }

    public Class<F> getFrom() { return fromClass; }
    public Class<T> getTo() { return toClass; }

    public abstract T convert(F from);
}