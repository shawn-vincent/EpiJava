/*
 *
 *
 */
package com.epijava.util.convert;

/**
 * Converter that converts all Java Strings to Integer objects, parsing the String.
 *
 * The null String, and the strings 'null' and '' result in a null Integer.
 **/
public class StringToInteger extends ConverterFn<String,Integer> {

    public StringToInteger() { super(String.class, Integer.class); }

    public Integer convert(String from) { 
	if (from == null || from.length() == 0 || "null".equals(from)) return null;
	return Integer.parseInt(from); 
    }

}