/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

/**
 * 
 *
 */
public class GrammarUtil {

    public static Object concat(final Object lhs, final Object rhs) {
        if (lhs == null && rhs == null) {
            return null;
        } else if (lhs == null) {
            return rhs;
        } else if (rhs == null) {
            return lhs;
        } else {
            final ArrayList<Object> r = new ArrayList<Object>();
    
            if (lhs instanceof Collection)
                r.addAll((Collection<?>) lhs);
            else
                r.add(lhs);
    
            if (rhs instanceof Collection)
                r.addAll((Collection<?>) rhs);
            else
                r.add(rhs);
    
            return r;
        }
    }

}
