/*
 * 
 */
package com.epijava.util.unify;

import java.util.List;

/**
 * Convenience matcher that matches a List.
 * 
 * <p>
 * Provides convenience methods to add sub-terms specific to Java Lists.
 * 
 */
public class MatchList extends Match {

    public MatchList() {
        this(List.class);
    }

    public <T extends List<?>> MatchList(Class<T> type) {
        super(type);
    }

    public MatchList get(int i, UnifyTerm t) {
        return (MatchList) add(new MatchListGet(this, i).add(t));
    }

    // { return (MatchList)callEq("get", new Class[]{int.class}, new
    // Object[]{i}, t); }

    public MatchList firstEq(UnifyTerm t) {
        return (MatchList) get(0, t);
    }

    public MatchList sizeEq(UnifyTerm t) {
        return (MatchList) callEq("size", t);
    }

    /**
     * 
     * 
     * 
     */
    private static class MatchListGet extends CallEnter {

        private final int index;

        public MatchListGet(Match _self, int index) {
            super(_self, "get", new Class[] { int.class },
                    new Object[] { index });
            this.index = index;
        }

        @Override
        public boolean unify(Object o, UnifyBindings bindings,
                boolean forceUnify) {

            if (!(o instanceof List))
                throw new AssertionError("Got non-list!");

            List<?> list = (List<?>) o;

            if (list.size() <= index) {
                if (forceUnify)
                    throw new UnificationFailedException(
                            "Expected list of length >= " + (index + 1)
                                    + " for get(), got length " + list.size());
                return false;
            }

            return super.unify(o, bindings, forceUnify);
        }

    }
}
