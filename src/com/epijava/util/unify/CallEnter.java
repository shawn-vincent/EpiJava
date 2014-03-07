package com.epijava.util.unify;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Matches the result of a method call.
 * 
 * <p>Call is one of the few UnifyTerms that changes the current object.
 * 
 * <p>If you add Call as a sub term to any UnifyTerm, it will invoke the specified 
 * Method, and attempt to unify the result of the method call with the specified
 * term.
 */
public class CallEnter extends UnifyTerm {

    /**
     * Set in constructor: throws exception on construction if
     * method does not exist.
     **/
    final Method method;
    
    final Object[] args;
    
    public CallEnter(Match _self, String _name, Class<?>[] _argTypes, Object[] _args) {
        this(findMethod(_self, _name, _argTypes), _args);
    }
    
    public CallEnter(Match _self, String _name, Object[] _args) {
        this(_self, _name, getArgTypes(_args), _args);
    }

    
    public CallEnter(Method _method, Object[] _args) {
        method = _method; args = _args;
    }
    
    private static Class<?>[] getArgTypes(Object[] _args) {
        Class<?>[] r = new Class[_args.length];
        for (int i=0; i<_args.length; i++)
            r[i] = _args[i].getClass(); // XXX NULL?
        return r;
    }

    private static Method findMethod(Match _self, String _name,
            Class<?>[] _argTypes) {
        
        // XXX do overloaded method lookup on all of the types in _self.
        
        
        for (Class<?> type : _self.instanceOfs) {
            try {
                return type.getMethod(_name, _argTypes);
            } catch (SecurityException ex) {
                throw new RuntimeException("Could not fetch method "
                        +_name+" "+Arrays.toString(_argTypes), ex);
            } catch (NoSuchMethodException ex) {
                // ignore and loop
            }
        }
        
        // XXX bad exception
        throw new RuntimeException("Could not find method "+_name+" "
                +Arrays.toString(_argTypes)+" in any of "
                +_self.instanceOfs);
    }

    public boolean unify(Object o, UnifyBindings bindings, boolean forceUnify) {
        Object result = invokeMethod(o);
        
        return super.unify(result, bindings, forceUnify);
    }

    private Object invokeMethod(Object o) {
        // XXX actually invoke the method on 'o' with the specified args
        try {
            return method.invoke(o, args);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Bad", ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException("Bad", ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex.getCause().getMessage(), ex.getCause());
        }
    }
}   
