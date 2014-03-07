/*
 * 
 */
package com.epijava.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.epijava.util.unify.*;

/**
 * 
 *
 */
public class UnifyTest {

    @Test
    public void testSimpleUnify() {
        // test
        Match pattern =
            new Match(Person.class)
            .field("name", new Var("X"))
            .callEq("getFormattedName", new Value("Unrah, george"))
            .field("friendNames", new MatchList().get(2, new Var("X"))
                   .get(1, new Var("Y"))
                   .firstEq(new Var("First")));
        
        UnifyBindings bindings =
            pattern.unify(new Person().setName("george"));
        
        assertEquals("george", bindings.get("X"));
        assertEquals("fred", bindings.get("First"));
        assertEquals("bill", bindings.get("Y"));
    }

    
    public static class Person {
        
        String name;

        public Person setName(String v) {
            name = v;
            return this;
        }
        
        public String getName() { return name; }
        
        public String getFormattedName() { return "Unrah, "+name; }
        
        public List<String> getFriendNames() 
        { return Arrays.asList("fred", "bill", "george"); }
        
    }
}
