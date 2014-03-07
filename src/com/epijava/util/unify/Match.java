/*
 * 
 */
package com.epijava.util.unify;

import java.util.ArrayList;
import java.util.List;

/**
 * Matches a Java object of a particular type.
 * 
 * <p>
 * Provides convenience methods to add subTerms to descend the object hierarchy.
 * 
 * 
 */
public class Match extends UnifyTerm {

    final List<Class<?>> instanceOfs = new ArrayList<Class<?>>();

    public Match(Class<?> _clazz) {
        instanceOf(_clazz);
    }

    public Match instanceOf(Class<?> _clazz) {
        instanceOfs.add(_clazz);
        return (Match) add(new MatchInstanceof(_clazz));
    }

    public Match callEq(String name, Class<?>[] argTypes, Object[] args,
            UnifyTerm term) {
        return (Match) add(new CallEnter(this, name, argTypes, args).add(term));
    }

    public Match callEq(String name, Object[] args, UnifyTerm term) {
        return (Match) add(new CallEnter(this, name, args).add(term));
    }

    public Match callEq(String name, UnifyTerm term) {
        return callEq(name, new Object[0], term);
    }

    public Match field(String name, UnifyTerm term) {

        if (name == null)
            throw new NullPointerException();
        if (name.length() == 0)
            throw new IllegalArgumentException(
                    "Empty string is not a valid field name");

        String getterName = "get" + Character.toUpperCase(name.charAt(0))
                + name.substring(1);

        return callEq(getterName, term);
    }
    
    public Match field(String name, Object v) {
        return field(name, new Value(v));
    }

    /**
     * 
     * 
     * 
     */
    private static class MatchInstanceof extends UnifyTerm {

        private final Class<?> clazz;

        public MatchInstanceof(Class<?> _clazz) {
            clazz = _clazz;
            if (clazz == null)
                throw new NullPointerException();
        }

        @Override
        public boolean unify(Object o, UnifyBindings bindings,
                boolean forceUnify) {
            if (!clazz.isInstance(o)) {
                if (forceUnify)
                    throw new UnificationFailedException(
                            "Expected instance of " + clazz.getName()
                                    + ", got " + 
                                    (o == null ? "NULL" : o.getClass().getName()));
                return false;
            }
            return true;
        }

    }


}
