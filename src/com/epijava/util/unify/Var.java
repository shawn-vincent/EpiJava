/*
 * 
 */
package com.epijava.util.unify;

/**
 * 
 * 
 */

public class Var extends UnifyTerm {
    private final String name;

    public Var(String _name) {
        name = _name;
    }

    @Override
    public boolean unify(Object o, UnifyBindings bindings, boolean forceUnify) {

        if (bindings.hasBinding(name)) {
            Object existingBinding = bindings.get(name);

            if (o == null && existingBinding == null)
                return true;
            if (o == null || existingBinding == null) {
                if (forceUnify)
                    throw new UnificationFailedException("Want to bind " + name
                            + " as " + o + ", already bound as "
                            + existingBinding);
                return false;
            }

            boolean r = o.equals(existingBinding);

            if (!r && forceUnify)
                if (forceUnify)
                    throw new UnificationFailedException("Want to bind " + name
                            + " as " + o + ", already bound as "
                            + existingBinding);

            return r;
        }

        bindings.put(name, o);

        return true;
    }
}
