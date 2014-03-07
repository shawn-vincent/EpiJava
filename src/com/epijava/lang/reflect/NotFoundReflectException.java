/*
 * 
 */
package com.epijava.lang.reflect;

/**
 * A subclass of ReflectException to throw when something (a class, method, etc)
 * is not found.
 * 
 */
public class NotFoundReflectException extends ReflectException {

    private static final long serialVersionUID = 1L;

    public NotFoundReflectException() {
    }

    public NotFoundReflectException(String msg) {
        super(msg);
    }

    public NotFoundReflectException(Throwable cause) {
        super(cause);
    }

    public NotFoundReflectException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
