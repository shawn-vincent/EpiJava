/*
 * 
 */
package com.epijava.lang.type;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Tests of the SimpleTypeLoader
 * 
 *
 */
public class SystemTypeLoaderTest {
    
    @Test
    public void testLoadClass() {
        Type t = SystemDefinitionLoader.getInstance().getDefinition(JavaName.type("java.lang.Object"));
        assertNotNull(t);
        assertEquals(JavaName.type("java.lang.Object"), t.getName());
        assertSame(t, SystemDefinitionLoader.getInstance().getDefinition(JavaName.type("java.lang.Object")));
    }
   
    @Test
    public void testMissingClass() {
        assertNull(SystemDefinitionLoader.getInstance().getDefinition(JavaName.type("java.lang.ObjectFOO")));
    }

}
