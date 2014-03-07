package com.epijava.build;

import com.epijava.lang.reflect.*;

/**
 *
 **/
public class EpiBuilder implements MethodNotFoundHandler {

    /**
     *
     **/
    public Object handlMethodNotFound(String methodName, Object[] args) {
        throw new AssertionError();
    }


}
