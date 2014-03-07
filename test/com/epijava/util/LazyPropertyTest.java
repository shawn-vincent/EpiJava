/*
 * 
 */
package com.epijava.util;

import static org.junit.Assert.*;

import java.util.concurrent.atomic.*;

import org.junit.*;

/**
 * Simple tests for LazyProperty
 *
 */
public class LazyPropertyTest {

    
    @Test
    public void testSimpleProperty() {
        LazyProperty<String> p = new LazyProperty<String> () {
            @Override
            protected String loadValue() {
                return "foo" + 42;
            }  
        };
        
        assertEquals("foo42", p.get());
    }

    @Test
    public void testMemoization() {
        final AtomicInteger i = new AtomicInteger(0);

        LazyProperty<String> p = new LazyProperty<String>() {
            @Override
            protected String loadValue() {
                return "foo" + i.incrementAndGet();
            }
        };

        // no matter how often we do this, we should get the same value.
        assertEquals("foo1", p.get());
        assertEquals("foo1", p.get());
        assertEquals("foo1", p.get());
    }

    @SuppressWarnings("unchecked")
    @Test(expected=LazyProperty.PropertyCycleException.class)
    public void testCycleDetection() {

        final LazyProperty<String>[] trick = new LazyProperty[1];
        
        final LazyProperty<String> a = new LazyProperty<String>("fetch A") {
            @Override
            protected String loadValue() {
                return trick[0].get();
            }
        };
        
        final LazyProperty<String> b = new LazyProperty<String>("fetch B") {
            @Override
            protected String loadValue() {
                return a.get();
            }
        };
        
        trick[0] = b;

        a.get();
    }

    
}
