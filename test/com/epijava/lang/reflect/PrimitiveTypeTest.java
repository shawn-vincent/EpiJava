/*
 * 
 */
package com.epijava.lang.reflect;

import static org.junit.Assert.*;

import static com.epijava.lang.type.PrimitiveType.*;

import org.junit.*;

import com.epijava.lang.type.*;

/**
 * Tests for PrimitiveType
 * 
 */
public class PrimitiveTypeTest {

    @Test
    public void testBoxing() {
        assertEquals(PrimitiveType.BooleanWrapper, PrimitiveType.Boolean.box());
        assertEquals(PrimitiveType.ByteWrapper, PrimitiveType.Byte.box());
        assertEquals(PrimitiveType.CharWrapper, PrimitiveType.Char.box());
        assertEquals(PrimitiveType.ShortWrapper, PrimitiveType.Short.box());
        assertEquals(PrimitiveType.IntWrapper, PrimitiveType.Int.box());
        assertEquals(PrimitiveType.LongWrapper, PrimitiveType.Long.box());
        assertEquals(PrimitiveType.FloatWrapper, PrimitiveType.Float.box());
        assertEquals(PrimitiveType.DoubleWrapper, PrimitiveType.Double.box());
        assertEquals(PrimitiveType.VoidWrapper, PrimitiveType.Void.box());
    }

    @Test
    public void testUnboxing() {
        assertEquals(PrimitiveType.Boolean, PrimitiveType.BooleanWrapper
                .unbox());
        assertEquals(PrimitiveType.Byte, PrimitiveType.ByteWrapper.unbox());
        assertEquals(PrimitiveType.Char, PrimitiveType.CharWrapper.unbox());
        assertEquals(PrimitiveType.Short, PrimitiveType.ShortWrapper.unbox());
        assertEquals(PrimitiveType.Int, PrimitiveType.IntWrapper.unbox());
        assertEquals(PrimitiveType.Long, PrimitiveType.LongWrapper.unbox());
        assertEquals(PrimitiveType.Float, PrimitiveType.FloatWrapper.unbox());
        assertEquals(PrimitiveType.Double, PrimitiveType.DoubleWrapper.unbox());
        assertEquals(PrimitiveType.Void, PrimitiveType.VoidWrapper.unbox());
    }

    /**
     * Test all combinations of primitive method parameter assignment, including
     * variants of boxing and unboxing.
     */
    @Test
    public void testPrimitiveMethodParmAssignment() {
        /*
         * JLS 3rd edition - 5.1.2 states:
         * 
         * The following 19 specific conversions on primitive types are called
         * the widening primitive conversions:
         */

        // byte to short, int, long, float, or double
        assertPrimitiveMethodAssignable(Byte, Byte);
        assertPrimitiveMethodAssignable(Byte, Short);
        assertPrimitiveMethodAssignable(Byte, Int);
        assertPrimitiveMethodAssignable(Byte, Long);
        assertPrimitiveMethodAssignable(Byte, Float);
        assertPrimitiveMethodAssignable(Byte, Double);

        assertNotPrimitiveMethodAssignable(Byte, Char);
        assertNotPrimitiveMethodAssignable(Byte, Boolean);
        assertNotPrimitiveMethodAssignable(Byte, Void);

        // short to int, long, float, or double
        assertPrimitiveMethodAssignable(Short, Short);
        assertPrimitiveMethodAssignable(Short, Int);
        assertPrimitiveMethodAssignable(Short, Long);
        assertPrimitiveMethodAssignable(Short, Float);
        assertPrimitiveMethodAssignable(Short, Double);

        assertNotPrimitiveMethodAssignable(Short, Byte);
        assertNotPrimitiveMethodAssignable(Short, Char);
        assertNotPrimitiveMethodAssignable(Short, Boolean);
        assertNotPrimitiveMethodAssignable(Short, Void);

        // char to int, long, float, or double
        assertPrimitiveMethodAssignable(Char, Char);
        assertPrimitiveMethodAssignable(Char, Int);
        assertPrimitiveMethodAssignable(Char, Long);
        assertPrimitiveMethodAssignable(Char, Float);
        assertPrimitiveMethodAssignable(Char, Double);

        assertNotPrimitiveMethodAssignable(Char, Byte);
        assertNotPrimitiveMethodAssignable(Char, Short);
        assertNotPrimitiveMethodAssignable(Char, Boolean);
        assertNotPrimitiveMethodAssignable(Char, Void);

        // int to long, float, or double
        assertPrimitiveMethodAssignable(Int, Int);
        assertPrimitiveMethodAssignable(Int, Long);
        assertPrimitiveMethodAssignable(Int, Float);
        assertPrimitiveMethodAssignable(Int, Double);

        assertNotPrimitiveMethodAssignable(Int, Byte);
        assertNotPrimitiveMethodAssignable(Int, Char);
        assertNotPrimitiveMethodAssignable(Int, Short);
        assertNotPrimitiveMethodAssignable(Int, Boolean);
        assertNotPrimitiveMethodAssignable(Int, Void);

        // long to float or double
        assertPrimitiveMethodAssignable(Long, Long);
        assertPrimitiveMethodAssignable(Long, Float);
        assertPrimitiveMethodAssignable(Long, Double);

        assertNotPrimitiveMethodAssignable(Long, Int);
        assertNotPrimitiveMethodAssignable(Long, Byte);
        assertNotPrimitiveMethodAssignable(Long, Char);
        assertNotPrimitiveMethodAssignable(Long, Short);
        assertNotPrimitiveMethodAssignable(Long, Boolean);
        assertNotPrimitiveMethodAssignable(Long, Void);

        // float to double
        assertPrimitiveMethodAssignable(Float, Float);
        assertPrimitiveMethodAssignable(Float, Double);

        assertNotPrimitiveMethodAssignable(Float, Long);
        assertNotPrimitiveMethodAssignable(Float, Int);
        assertNotPrimitiveMethodAssignable(Float, Byte);
        assertNotPrimitiveMethodAssignable(Float, Char);
        assertNotPrimitiveMethodAssignable(Float, Short);
        assertNotPrimitiveMethodAssignable(Float, Boolean);
        assertNotPrimitiveMethodAssignable(Float, Void);

        // no widening on double, boolean, or void
        assertPrimitiveMethodAssignable(Double, Double);

        assertNotPrimitiveMethodAssignable(Double, Float);
        assertNotPrimitiveMethodAssignable(Double, Long);
        assertNotPrimitiveMethodAssignable(Double, Int);
        assertNotPrimitiveMethodAssignable(Double, Byte);
        assertNotPrimitiveMethodAssignable(Double, Char);
        assertNotPrimitiveMethodAssignable(Double, Short);
        assertNotPrimitiveMethodAssignable(Double, Boolean);
        assertNotPrimitiveMethodAssignable(Double, Void);

        assertPrimitiveMethodAssignable(Boolean, Boolean);

        assertNotPrimitiveMethodAssignable(Boolean, Double);
        assertNotPrimitiveMethodAssignable(Boolean, Float);
        assertNotPrimitiveMethodAssignable(Boolean, Long);
        assertNotPrimitiveMethodAssignable(Boolean, Int);
        assertNotPrimitiveMethodAssignable(Boolean, Byte);
        assertNotPrimitiveMethodAssignable(Boolean, Char);
        assertNotPrimitiveMethodAssignable(Boolean, Short);
        assertNotPrimitiveMethodAssignable(Boolean, Void);

        assertPrimitiveMethodAssignable(Void, Void);

        assertNotPrimitiveMethodAssignable(Void, Double);
        assertNotPrimitiveMethodAssignable(Void, Float);
        assertNotPrimitiveMethodAssignable(Void, Long);
        assertNotPrimitiveMethodAssignable(Void, Int);
        assertNotPrimitiveMethodAssignable(Void, Byte);
        assertNotPrimitiveMethodAssignable(Void, Char);
        assertNotPrimitiveMethodAssignable(Void, Short);
        assertNotPrimitiveMethodAssignable(Void, Boolean);

    }

    /**
     * Assert that 'from' is assignable to 'to'.
     * 
     * Checks both the primitive type 'to' and the boxed version of it.
     */
    private void assertPrimitiveMethodAssignable(PrimitiveType<?> from,
            PrimitiveType<?> to) {
        assertTrue("Primitive not assignable!?", to
                .isMethodParmAssignableFrom(from, true));
        assertTrue("Boxed primitive not assignable!?", to
                .isMethodParmAssignableFrom(from.box(), true));

        // we don't box 'to' here because JLS doesn't want us to. In JLS 3rd
        // edition - 5.3 Method Invocation Conversion, we see:
        
        /*
         * - an identity conversion (¤5.1.1)
         * 
         * - a widening primitive conversion (¤5.1.2)
         * 
         * - a widening reference conversion (¤5.1.5)
         * 
         * - a boxing conversion (¤5.1.7) optionally followed by widening
         * reference conversion
         * 
         * - an unboxing conversion (¤5.1.8) optionally followed by a widening
         * primitive conversion.
         */
        
        // so if we box the argument type, we only do a widening REFERENCE
        // conversion.
    }

    private void assertNotPrimitiveMethodAssignable(PrimitiveType<?> from,
            PrimitiveType<?> to) {
        assertFalse("Primitive assignable: expected not!?", to
                .isMethodParmAssignableFrom(from, true));
        assertFalse("Boxed primitive assignable: expected not!?", to
                .isMethodParmAssignableFrom(from.box(), true));

    }

}
