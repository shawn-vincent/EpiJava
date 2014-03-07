/*
 * 
 */
package com.epijava.lang.reflect;

import static org.junit.Assert.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import org.junit.*;

import com.epijava.lang.test.*;
import com.epijava.lang.type.*;

/**
 * An attempt at relatively thorough testing of the Epijava Multimethods
 * 
 */
public class MultimethodTest extends EpiTestCase {

    private static final Date Date = new Date();

    public static Object callInstance(Class<?> type, Object self, String name, Object... args) {
        return Multimethod.create(SimpleType.make(type), name, args.length)
                .invoke(self, args);
    }

    public static Object call(Class<?> type, String name, Object... args) {
        return Multimethod.create(SimpleType.make(type), name, args.length)
                .invokeStatic(args);
    }

    public static Object callTyped(Class<?> type, String name,
            Class<?>[] classes, Object... args) {
        return Multimethod.create(SimpleType.make(type), name, args.length)
                .invokeStaticSpecifiedTypes(SimpleType.make(classes), args);
    }

    public static Object r(String methodDesc, Object... args) {
        List<Object> r = new ArrayList<Object>();
        r.add(methodDesc);
        r.addAll(Arrays.asList(args));
        return r;
    }

    @Test
    public void testPrimitiveCall() {

        // try boxed and unboxed variants of a primitive parameter
        assertEquals(PrimitiveCall.f(42), callTyped(PrimitiveCall.class, "f",
                new Class[] { int.class }, 42)); // int == int

        // try widening primitive coercion of a primitive parameter
        assertEquals(PrimitiveCall.f((byte) 42), callTyped(PrimitiveCall.class,
                "f", new Class[] { byte.class }, (byte) 42)); // byte -> int

        // try widening reference coercion of a primitive parameter
        assertEquals(PrimitiveCall.f(42L), callTyped(PrimitiveCall.class, "f",
                new Class[] { long.class }, 42L)); // long -> Long -> Object

        // try boxed and unboxed variants of a boxed parameter
        assertEquals(PrimitiveCall.f(42.0), callTyped(PrimitiveCall.class, "f",
                new Class[] { double.class }, 42.0)); // double == double
    }

    @Test
    public void testPrimitiveCallUnboxingVersusReferencePromotion() {
        assertEquals(PrimitiveCall.f(new Integer(42)), call(
                PrimitiveCall.class, "f", new Integer(42))); // Integer ->
        // int
        assertEquals(PrimitiveCall.f(new Byte((byte) 42)), call(
                PrimitiveCall.class, "f", new Byte((byte) 42))); // Byte ->
        // byte ->
        // int
        assertEquals(PrimitiveCall.f(new Double(42.0)), call(
                PrimitiveCall.class, "f", new Double(42.0))); // Double ->
        // double
    }

    public static class PrimitiveCall {
        public static Object f(Object o) {
            return r("Object", o);
        }

        public static Object f(String o) {
            return r("String", o);
        }

        public static Object f(int v) {
            return r("int", v);
        }

        public static Object f(Double v) {
            return r("Double", v);
        }

        public static Object f(Collection<?> v) {
            return r("Collection", v);
        }
    }

    @Test
    public void testSimpleMultimethod() {
        // widening reference coercion of an object parameter
        Date d = new Date();
        assertEquals(SimpleMultimethod.f(d), call(SimpleMultimethod.class, "f",
                d));

        // simple match on String
        assertEquals(SimpleMultimethod.f("Hello"), call(
                SimpleMultimethod.class, "f", "Hello"));

        // another widening reference coercion, but not all the way to Object
        assertEquals(SimpleMultimethod.f(new HashSet<Object>()), call(
                SimpleMultimethod.class, "f", new HashSet<Object>()));
    }

    public static class SimpleMultimethod {
        public static Object f(Object o) {
            return r("Object", o);
        }

        public static Object f(String o) {
            return r("String", o);
        }

        public static Object f(int v) {
            return r("int", v);
        }

        public static Object f(Double v) {
            return r("Double", v);
        }

        public static Object f(Collection<?> v) {
            return r("Collection", v);
        }
    }

    @Test(expected = NotFoundReflectException.class)
    public void testNotFound() {
        // NotFound.f(new Object()); -- this is a compile error
        call(NotFound.class, "f", new Object()); // this is a runtime error
    }

    public static class NotFound {
        public static Object f(int v) {
            return r("int", v);
        }
    }

    @Test(expected = NotFoundReflectException.class)
    public void testNoSuchMethod() {
        // NoSuchMethod.g(new Object()); -- this is a compile error
        Multimethod.create(SimpleType.make(NoSuchMethod.class), "g", 1); // this
        // is a
        // runtime
        // error
    }

    public static class NoSuchMethod {
        public static Object f(int v) {
            return r("int", v);
        }
    }

    @Test
    public void testTwoArgMultimethod() {

        assertEquals(TwoArgMultimethod.f(Date, "Foo"), call(
                TwoArgMultimethod.class, "f", Date, "Foo"));

        assertEquals(TwoArgMultimethod.f("Foo", "Hello"), call(
                TwoArgMultimethod.class, "f", "Foo", "Hello"));

        assertEquals(TwoArgMultimethod.f("Foo", 42), callTyped(
                TwoArgMultimethod.class, "f", new Class[] { int.class }, "Foo",
                42));
    }

    public static class TwoArgMultimethod {
        public static Object f(Object a, Object b) {
            return r("Object,Object", a, b);
        }

        public static Object f(String a, String b) {
            return r("String,String", a, b);
        }

        public static Object f(Object a, int b) {
            return r("Object,int", a, b);
        }
    }

    @Test(expected = AmbiguousMethodInvocationException.class)
    public void testAmbiguousMultimethod() throws Exception {

        // should be ambiguous (this method call doesn't compile)
        // AmbiguousMultimethod.f(new ArrayList<Object>());

        call(AmbiguousMultimethod.class, "f", new ArrayList<Object>());
    }

    public static class AmbiguousMultimethod {
        public static Object f(Collection<?> v) {
            return r("Collection", v);
        }

        public static Object f(Serializable v) {
            return r("Serializable", v);
        }
    }

    @Test
    public void testVarArgs() {
        assertEquals(VarArgs.f("foo", 42), callTyped(VarArgs.class, "f",
                new Class[] { String.class, int.class }, "foo", 42));

        // kindof counterintuitive: you would expect Object... (similar to
        // Object, Object), but Phase 3 of method resolution looks at var args
        // AND boxing/unboxing. So you get Object, int
        assertEquals(VarArgs.f("foo", new Integer(42)), call(VarArgs.class,
                "f", "foo", new Integer(42)));

        assertEquals(VarArgs.f("foo", "bar"), call(VarArgs.class, "f", "foo",
                "bar"));
        assertEquals(VarArgs.f("foo", Date), call(VarArgs.class, "f",
                "foo", Date));

        // more than 2 args...
        assertEquals(VarArgs.f("foo", "bar", "baz"), call(VarArgs.class, "f",
                "foo", "bar", "baz"));
        assertEquals(VarArgs.f("foo", 12, 14), call(VarArgs.class, "f", "foo",
                12, 14));
    }

    public static class VarArgs {
        public static Object f(Object... o) {
            return r("Object...: ", o);
        }

        public static Object f(String o, int v) {
            return r("String, int", o, v);
        }

        public static Object f(String o, String b) {
            return r("String, String", o, b);
        }
    }

    /**
     * From Java Puzzlers book: obscure edge case.
     */
    @Test
    public void testClassyPuzzle() {
        assertEquals(ClassyPuzzle.f(null), call(ClassyPuzzle.class, "f",
                (Object) null));
    }

    public static class ClassyPuzzle {
        public static Object f(Object o) {
            return r("Object", o);
        }

        public static Object f(double[] dArray) {
            return r("double[]", dArray);
        }
    }

    /**
     * From JDC Tech Tips: March 14, 2000
     * 
     * http://java.sun.com/developer/TechTips/2000/tt0314.html#tip2
     */
    @Test
    public void testTechTipExample() {
        assertEquals(TechTipExample.f(37), call(TechTipExample.class, "f", 37));
    }

    public static class TechTipExample {
        public static Object f(float f) {
            return r("float", f);
        }

        public static Object f(double d) {
            return r("double", d);
        }
    }

    /**
     * I don't believe this should be a compile error, but it is in Eclipse.
     */
    // @Test
    // public void testTechTipExample2() {
    // assertEquals(TechTipExample2.f(37, 37), call(TechTipExample2.class, "f",
    // 37, 37));
    // }
    // public static class TechTipExample2 {
    // public static Object f(float f, double d) {
    // return r("float,double", f, d);
    // }
    // private static Object f(double d, float f) {
    // return r("double,float", d, f);
    // }
    // }
    
    @Test(expected=AmbiguousMethodInvocationException.class)
    public void testTechTipExample2Ambiguous() {
        // TechTipExample2.f(37, 37); -- compile time error.
        call(TechTipExample2.class, "f", 37, 37);
    }

    public static class TechTipExample2 {
        public static Object f(float f, double d) {
            return r("float,double", f, d);
        }

        public static Object f(double d, float f) {
            return r("double,float", d, f);
        }
    }
    
    @Test
    public void testSubclassA() {
        assertEquals(new SubclassA().f(Date), callInstance(SubclassA.class, new SubclassA(), "f", Date));
    }
    
    public static class SuperclassA {
        public Object f(Date v) {
            return r("SuperDate", v);
        }
        public Object f(Object v) {
            return r("SuperObject", v);
        }
    }
    
    public static class SubclassA {
        public Object f(Object v) {
            return r("SubObject", v);
        }
    }

    /**
     * Main method for profiling.
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        new MultimethodTest().testMultimethodSpeed();
    }

    @Test @Ignore
    public void testMultimethodSpeed() throws Exception {
        final int Count = 1000000;
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < Count; i++)
            MultimethodSpeed.f("Bar" + i);
        long e1 = System.currentTimeMillis();
        long dur1 = (e1 - s1);

        Method m = MultimethodSpeed.class.getMethod("f", String.class);
        long sR = System.currentTimeMillis();
        for (int i = 0; i < Count; i++)
            m.invoke(null, "Bar" + i);
        long eR = System.currentTimeMillis();
        long durR = (eR - sR);

        Multimethod mm = Multimethod.create(SimpleType
                .make(MultimethodSpeed.class), "f", 1);
        long s2 = System.currentTimeMillis();
        for (int i = 0; i < Count; i++)
            mm.invoke(null, "Bar" + i);
        long e2 = System.currentTimeMillis();
        long dur2 = (e2 - s2);

        System.out.println("Performance of multimethod library:");
        System.out.println("    Count == " + Count);
        System.out.println("    raw == " + (dur1) + " ms");
        System.out.println("    reflective == " + (durR) + " ms");
        System.out.println("    epi multimethod == " + (dur2) + " ms");
        System.out.println("    epi multimethod overhead from reflective == "
                + (dur2 * 100 / durR - 100) + "%");
        System.out.println("    epi multimethod overhead from raw == "
                + (dur2 * 100 / dur1 - 100) + "%");
    }

    public static class MultimethodSpeed {
        public static String f(Object o) {
            return "Object";
        }

        public static String f(String o) {
            return "String";
        }

        public static String f(int v) {
            return "int";
        }

        public static String f(Double v) {
            return "Double";
        }

        public static String f(Collection<?> v) {
            return "Collection";
        }
    }

}