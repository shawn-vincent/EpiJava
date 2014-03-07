/*
 * 
 */
package com.epijava.lang;

/**
 * 
 *
 */
public class EpiRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EpiRuntimeException() {
    }

    /**
     * @param msg
     */
    public EpiRuntimeException(String msg) {
        super(msg);
    }

    /**
     * @param ex
     */
    public EpiRuntimeException(Throwable ex) {
        super(ex);
    }

    /**
     * @param msg
     * @param ex
     */
    public EpiRuntimeException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
