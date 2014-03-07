package com.epijava.util.unify;

import java.util.ArrayList;
import java.util.List;

/**
 * The base unification term.
 * 
 * <p>
 * Can be unified against any Java object. This will either succeed (the term
 * matches the object) or fail (no match).
 * 
 * <p>
 * If the match succeeds, a set of Bindings is returned that represents the
 * bindings of any Var terms contained in the pattern.
 */
public class UnifyTerm {
    final List<UnifyTerm> subTerms = new ArrayList<UnifyTerm>();

    public static Match match(Class<?> c) { return new Match(c); }
    public static MatchList list() { return new MatchList(); }
    public static Value value(Object o) { return new Value(o); }
    public static Var var(String name) { return new Var(name); }
    
    public UnifyTerm add(UnifyTerm term) {
        subTerms.add(term);
        return this;
    }

    public UnifyBindings unify(Object o) {
        UnifyBindings r = new UnifyBindings();
        if (!unify(o, r, false))
            return null;
        return r;
    }

    public UnifyBindings forceUnify(Object o) {
        UnifyBindings r = new UnifyBindings();
        if (!unify(o, r, true))
            throw new AssertionError(
                    "Got false from unify when forceUnify == true!?");
        return r;
    }

    public boolean unify(Object o, UnifyBindings bindings, boolean forceUnify) {
        for (UnifyTerm term : subTerms) {
            if (!term.unify(o, bindings, forceUnify)) {
                if (forceUnify)
                    throw new AssertionError(
                            "Got false from unify when forceUnify == true!?");
                return false;
            }
        }
        return true;
    }
}
