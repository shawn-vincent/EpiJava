/*
 * 
 */
package com.epijava.lang.misc;

import org.junit.*;

/**
 * Simple tests to investigate some edge cases for Java reference binding.
 * 
 */
public class JavaReferenceBindingTest {
    
    Foo instanceFoo;

    @SuppressWarnings("static-access")
    @Test
    public void testBinding() {
        
        Foo f = new Foo();
        
//        new f.Bar(); // doesn't compile under Eclipse
        
//        new instanceFoo.Bar(); Also doesn't compile under Eclipse
        
        System.out.println(f.FooStatic); // this works.
        
//        f.Bar.BarStatic; // but this doesn't.
        
        
    }
    
    
    public Foo getFoo() { return new Foo(); }
    
    public static class Foo {
        
        public static int FooStatic = 42;
        
        public static class Bar {
            
            public static int BarStatic = 43;
            
        }
    }
}
