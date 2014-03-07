/*
 *
 *
 */
package com.epijava.util.convert;

/**
 * Converter that converts all Java objects to Strings, using 'toString'.
 **/
public class ObjectToString extends ConverterFn<Object,String> {

    public ObjectToString() { super(Object.class, String.class); }

    public String convert(Object from) { return String.valueOf(from); }

}