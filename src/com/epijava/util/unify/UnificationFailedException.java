/*
 * 
 */
package com.epijava.util.unify;

/**
 * 
 *
 */
public class UnificationFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnificationFailedException() {
    }

    public UnificationFailedException(String arg0) {
        super(arg0);
    }

    public UnificationFailedException(Throwable arg0) {
        super(arg0);
    }

    public UnificationFailedException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
