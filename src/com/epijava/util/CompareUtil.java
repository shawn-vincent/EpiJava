/*
 * 
 */
package com.epijava.util;


/**
 * A suite of methods for implementing comparisons succinctly.
 *
 */
public class CompareUtil {

    /**
     * Calculate a quality hash code based on the objects specified.
     * 
     * <p>
     * Based on the algorithm used in the autogenerated hashCode() methods in
     * Eclipse
     */
    public static final int hashCode(Object... objs) {
        final int prime = 31;
        int result = 0;
        for (Object o : objs) {
            result = prime * result + ((o == null) ? 0 : o.hashCode());
        }
        return result;
    }

    /**
     * Return true iff the two objects specified are equal.
     * 
     * <p>
     * Same as a.equals(b), except that this method deals with nulls, and
     * optimizes the case where a == b.
     */
    public static final boolean equals(Object a, Object b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        return a.equals(b);
    }
}
