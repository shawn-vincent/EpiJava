package com.epijava.util.unify;

public class Value extends UnifyTerm {
    final Object value;
    
    public Value(Object _value) {
        value = _value;
    }

    @Override
    public boolean unify(Object o, UnifyBindings bindings, boolean forceUnify) {
        if (o == null && value == null)
            return true;
        
        if (o == null || value == null) {
            if (forceUnify)
                throw new UnificationFailedException("Expected "+value+", got "+o);
            return false;
        }
        
        boolean r = o.equals(value);
        
        if (!r && forceUnify)
            throw new UnificationFailedException("Expected "+value+", got "+o);
        
        return r;
    }
}