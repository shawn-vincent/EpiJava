/*
 *
 *
 */
package com.epijava.lang.parser;

import com.epijava.lang.*;

/**
 * Exception thrown by the Javai parser
 **/
public class EpiParseException extends EpiException {
    private static final long serialVersionUID = 1L;
	public EpiParseException () { super (); }
    public EpiParseException (String msg) { super (msg); }
    public EpiParseException (String msg, Throwable ex) { super (msg, ex); }
}