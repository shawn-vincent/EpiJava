/*
 * 
 */
package com.epijava.lang.reflect;

/**
 * 
 * 
 */
public class ReflectException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReflectException() {
    }

    public ReflectException(String msg) {
        super(msg);
    }

    public ReflectException(Throwable cause) {
        super(cause);
    }

    public ReflectException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
