/*
 * 
 */
package com.epijava.grammar;

import static org.junit.Assert.*;

import org.junit.*;

import com.epijava.grammar.LocusBuilder.*;
import com.epijava.util.*;
import com.epijava.util.Locus.*;

/**
 * 
 */
public class LocusBuilderTest {
    
    @Test
    public void testBasics() {
        String string = "food\nmonster\rcreature\r\nhorizon";
        ObjectStream<CodePoint> s = ObjectStream.make(string);
        
        LocusBuilder builder = new CharStreamLocusBuilder(s, "<unknown>");
        
        assertEquals(new ConstantLocus("<unknown>", 0, 0), builder.buildLocus(null, 0));
        assertEquals(new ConstantLocus("<unknown>", 1, 0), builder.buildLocus(null, string.indexOf("monster")));
        assertEquals(new ConstantLocus("<unknown>", 1, 1), builder.buildLocus(null, string.indexOf("onster")));
        assertEquals(new ConstantLocus("<unknown>", 2, 0), builder.buildLocus(null, string.indexOf("creature")));
        assertEquals(new ConstantLocus("<unknown>", 3, 0), builder.buildLocus(null, string.indexOf("horizon")));
        assertEquals(new ConstantLocus("<unknown>", 3, 3), builder.buildLocus(null, string.indexOf("izon")));
    }
    
    @Test
    public void testNewlines() {
        String string = "food\nmonster\rcreature\r\nhorizon";
        ObjectStream<CodePoint> s = ObjectStream.make(string);
        
        LocusBuilder builder = new CharStreamLocusBuilder(s, "<unknown>");
        
        assertEquals(new ConstantLocus("<unknown>", 0, 0), builder.buildLocus(null, 0));
        assertEquals(new ConstantLocus("<unknown>", 0, 4), builder.buildLocus(null, string.indexOf("\nmonster")));
        assertEquals(new ConstantLocus("<unknown>", 1, 7), builder.buildLocus(null, string.indexOf("\rcreature")));
        assertEquals(new ConstantLocus("<unknown>", 2, 8), builder.buildLocus(null, string.indexOf("\r\nhorizon")));
        assertEquals(new ConstantLocus("<unknown>", 2, 9), builder.buildLocus(null, string.indexOf("\nhorizon")));
    }
    
    @Test
    public void testReadPastEnd() {
        String string = "food\nmonster\rcreature\r\nhorizon";
        ObjectStream<CodePoint> s = ObjectStream.make(string);
        
        LocusBuilder builder = new CharStreamLocusBuilder(s, "<unknown>");
        
        // this works...
        assertEquals(976, ((ConstantLocus)builder.buildLocus(null, 999)).locusColumn());
        assertEquals(3, ((ConstantLocus)builder.buildLocus(null, 999)).locusPosition());
    }
    
}
