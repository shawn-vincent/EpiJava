/*
 * 
 */
package com.epijava.lang.reflect;

import java.lang.reflect.*;
import java.util.*;

import com.epijava.lang.type.*;

/**
 * 
 * 
 */
public class AmbiguousMethodInvocationException extends ReflectException {

    private static final long serialVersionUID = 1L;

    private final String methodName;
    private final List<SimpleType<?>> argTypes;
    private final List<AccessibleObject> ambiguousMethods;

    public AmbiguousMethodInvocationException(String _methodName,
            List<SimpleType<?>> _argTypes, List<AccessibleObject> _ambiguousMethods) {
        super(calculateMessage(_methodName, _argTypes, _ambiguousMethods));
        methodName = _methodName;
        ambiguousMethods = Collections.unmodifiableList(_ambiguousMethods);
        argTypes = Collections.unmodifiableList(_argTypes);
    }
    
    public String getMethodName() {
        return methodName;
    }

    public List<AccessibleObject> getAmbiguousMethods() {
        return ambiguousMethods;
    }

    public List<SimpleType<?>> getArgTypes() {
        return argTypes;
    }

    private static String calculateMessage(String methodName,
            List<SimpleType<?>> argTypes, List<AccessibleObject> methods) {
        return "The method " + methodName + "("
                + SimpleType.toString(argTypes) + ") is ambiguous";
    }

}
