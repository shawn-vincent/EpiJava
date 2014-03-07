/*
 * 
 */
package com.epijava.lang.type;

import java.util.*;

/**
 * 
 *
 */
public class FunctionType extends Type {
    
    private final Type returnType;
    private final List<Type> parameterTypes;
    private final List<Type> throwsTypes;

    public FunctionType(List<Type> _parameterTypes, Type _returnType,
            List<Type> _throwsTypes) {
        parameterTypes = internalize(_parameterTypes);
        returnType = _returnType;
        throwsTypes = internalize(_throwsTypes);
    }

    private List<Type> internalize(List<Type> types) {
        if (types == null)
            return Collections.unmodifiableList(new ArrayList<Type>());
        else
            return Collections.unmodifiableList(types);
    }

    @Override
    public JavaName<Type> getName() {
        StringBuilder r = new StringBuilder();
        r.append("{");
        appendAll(r, parameterTypes);
        r.append("=>");
        r.append(returnType.getName().getName());
        if (!throwsTypes.isEmpty()) {
            r.append(" throws ");
            appendAll(r, throwsTypes);
        }
        r.append("}");
        return JavaName.type(r.toString());
    }

    private void appendAll(StringBuilder r, List<Type> types) {
        boolean first = true;
        for (Type t : types) {
            if (!first) r.append(", ");
            else first = false;
            r.append(t);
        }
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<Type> getParameterTypes() {
        return parameterTypes;
    }

    public List<Type> getThrowsTypes() {
        return throwsTypes;
    }

}
