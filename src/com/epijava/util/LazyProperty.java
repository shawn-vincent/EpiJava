/*
 * 
 */
package com.epijava.util;

import java.util.*;


/**
 * A lazy (memoized) property.
 * 
 * <p>
 * Subclasses override 'loadValue' to do whatever they would like.
 * 
 * <p>
 * The LazyProperty guarantees:
 * 
 * <ul>
 * <li>a single instance of LazyProperty will call loadValue once, regardless
 * of how often you call 'get'
 * 
 * <li>any cyclic dependency of LazyProperties (any LazyProperty that, through
 * any chain of LazyProperty.loadValue directly or indirectly tries to call
 * LazyProperty.get on itself) results in a PropertyCycleException with the
 * chain of offending properties
 * </ul>
 * 
 * <p>
 * Note: uses a ThreadLocal to do cycle detection, so keep it on the same
 * thread.
 * 
 */
public abstract class LazyProperty<T> {
    
    private static final ThreadLocal<Set<LazyProperty<?>>> AlreadySeenProperties =
        new ThreadLocal<Set<LazyProperty<?>>>() {
            @Override
            protected Set<LazyProperty<?>> initialValue() {
                return new LinkedHashSet<LazyProperty<?>>();
            }
    };
    
    private final String description;

    volatile private T memoizedValue = null;
    volatile private boolean hasMemoizedValue = false;
    
    /**
     * Specify 'description' to get a more meaningful error message on cycles.
     */
    public LazyProperty(String _description) {
        description = _description;
    }

    /**
     * 
     */
    public LazyProperty() {
        this (null);
    }
    
    public T get() {
        // double checked locking: this works in JDK5 and above.
        // http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
        if (!hasMemoizedValue)
            synchronized (this) {
                if (!hasMemoizedValue) {
                    memoizedValue = loadValueNoCycles();
                    hasMemoizedValue = true;
                }
            }

        return memoizedValue;
    }
    
    private T loadValueNoCycles() {
        Set<LazyProperty<?>> alreadySeenProperties = AlreadySeenProperties.get();
        
        if (alreadySeenProperties.contains(this)) {
            // calculate the sublist of the properties that describes the cycle.
            ArrayList<LazyProperty<?>> alreadySeenList = new ArrayList<LazyProperty<?>> (alreadySeenProperties);
            int firstOccurance = alreadySeenList.indexOf(this);
            List<LazyProperty<?>> justTheCycle = alreadySeenList.subList(firstOccurance, alreadySeenList.size());
            justTheCycle.add(this);
            
            // make an exception.
            throw new PropertyCycleException(justTheCycle);
        }
        
        alreadySeenProperties.add(this);
        try {
            return loadValue();
        } finally {
            alreadySeenProperties.remove(this);
        }
    }
    
    protected abstract T loadValue();
    
    public String toConciseString() {
        if (description == null)
            return super.toString();
        else
            return description;
    }
    
    public static class PropertyCycleException extends RuntimeException {
        
        private final List<LazyProperty<?>> propertyCycle;

        public PropertyCycleException(List<LazyProperty<?>> _propertyCycle) {
            super(makeMessage(_propertyCycle));
            propertyCycle = _propertyCycle;
        }

        private static String makeMessage(List<LazyProperty<?>> cycle) {
            StringBuilder r = new StringBuilder();
            r.append("Cyclic dependency: ");
            for (LazyProperty<?> p : cycle) {
                r.append(" => ");
                r.append(p.toConciseString());
            }
            return r.toString();
        }
        
        public List<LazyProperty<?>> getPropertyCycle() { return propertyCycle; }

        private static final long serialVersionUID = 1L;
    }
}
