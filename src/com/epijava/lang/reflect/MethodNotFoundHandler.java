package com.epijava.lang.reflect;

public interface MethodNotFoundHandler {

    public Object handlMethodNotFound(String methodName, Object[] args);

}