/*
 *
 *
 */
package com.epijava.lang.print;

import com.epijava.lang.*;

/**
 * Base class for exceptions thrown by Javai
 **/
public class EpiPrintException extends EpiRuntimeException {
	private static final long serialVersionUID = 1L;
	public EpiPrintException () { super (); }
    public EpiPrintException (String msg) { super (msg); }
    public EpiPrintException (String msg, Throwable ex) { super (msg, ex); }
}