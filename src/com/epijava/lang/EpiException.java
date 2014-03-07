/*
 *
 *
 */
package com.epijava.lang;

/**
 * Base class for exceptions thrown by Javai
 **/
public class EpiException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EpiException () { super (); }
    public EpiException (String msg) { super (msg); }
    public EpiException (String msg, Throwable ex) { super (msg, ex); }
}