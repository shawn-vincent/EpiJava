/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

import com.epijava.util.*;

/**
 * An abstract stream of Objects.
 *
 */
public abstract class ObjectStream<T> {
        
    protected ObjectStream() {
    }
    
    // make interface smarter, allow backtracking without requiring whole stream
    // in memory at once.
    public abstract int size();
    public abstract T get(int pos);
    
    public List<T> toSemanticValue() {
        final ArrayList<T> r = new ArrayList<T>();
        for (int i = 0; i < size(); i++)
            r.add(get(i));
        return r;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ObjectStream<T> make(final Object o) {
        if (o instanceof List)
            return new ListTokenStream<T>((List<T>)o);
        return new SingletonTokenStream<T>((T)o);
    }
    
    public static class EmptyTokenStream<T> extends ObjectStream<T> {
        @Override
        public int size() { return 0; }
        @Override
        public T get(final int pos) { return null; }
    }
    
    public static class SingletonTokenStream<T> extends ObjectStream<T> {
        private final T value;
        
        public SingletonTokenStream(final T _value) { value = _value; }
        @Override
        public int size() { return 1; }
        @Override
        public T get(final int pos) { return value; }
    }
    
    public static class ListTokenStream<T> extends ObjectStream<T> {
        private final List<T> list;
        public ListTokenStream(final List<T> _list) { list = _list; }
        @Override
        public int size() { return list.size(); }
        @Override
        public T get(final int pos) { return list.get(pos); }
    }
    
    public static <T> ObjectStream<T> make(final T[] array) {
        return make(Arrays.asList(array));
    }
    
    public static ObjectStream<CodePoint> make(final String string) {
        return make(new CodePointList(string));
    }
    
}
