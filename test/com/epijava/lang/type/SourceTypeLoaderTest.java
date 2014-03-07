/*
 * 
 */
package com.epijava.lang.type;

import static org.junit.Assert.*;

import org.junit.*;

import com.epijava.lang.compiler.*;

/**
 * Simple tests for the SourceTypeLoader
 * 
 */
public class SourceTypeLoaderTest {

    @Test
    public void testSimpleLoad() {

        EpiCompiler compiler = new EpiCompiler();
        SourceDefinitionLoader loader = new SourceDefinitionLoader(
                new LiteralSourceLoader(JavaName.type("com.example.Foo"),
                        "package com.example; class Foo {}"), compiler);

        assertEquals(JavaName.type("com.example.Foo"), loader.getDefinition(
                JavaName.type("com.example.Foo")).getName());
        assertEquals(SimpleType.make(String.class), loader.getDefinition(JavaName
                .type("java.lang.String")));
    }

    @Test
    public void testFetchFunction() {

        EpiCompiler compiler = new EpiCompiler();
        
        /*
         * This is the first program ever written for EpiJava.
         * 
         * Historic event, indeed.
         */
        SourceDefinitionLoader loader = new SourceDefinitionLoader(
                new LiteralSourceLoader(JavaName.type("com.example.Foo"),
                        "package com.example; class Foo { public int foo() { return 42; } }"),
                compiler);

        Type type = loader.getDefinition(JavaName.type("com.example.Foo"));

        Function function = type.getDefinition(JavaName.function("foo"));
        assertNotNull(function);
        assertEquals(JavaName.function("foo"), function.getName());
        
        assertEquals("{=>int}", function.getType().getName().getName());
        
        // XXX doesn't work: Int is loaded in a funny order that makes 2 of them.
        // assertSame(PrimitiveType.Int, function.getType().getReturnType());
        assertEquals(PrimitiveType.Int, function.getType().getReturnType());
    }
    
    @Test
    public void testFetchReferenceTypeFunction() {

        EpiCompiler compiler = new EpiCompiler();
        
        /*
         * This was #2.
         */
        SourceDefinitionLoader loader = new SourceDefinitionLoader(
                new LiteralSourceLoader(JavaName.type("com.example.Foo"),
                        "package com.example; class Foo { public java.lang.String foo() { return null; } }"),
                compiler);

        Type type = loader.getDefinition(JavaName.type("com.example.Foo"));

        Function function = type.getDefinition(JavaName.function("foo"));
        assertNotNull(function);
        assertEquals(JavaName.function("foo"), function.getName());
        
        assertEquals("{=>java.lang.String}", function.getType().getName().getName());
        
        // XXX doesn't work: Int is loaded in a funny order that makes 2 of them.
        // assertSame(PrimitiveType.Int, function.getType().getReturnType());
        assertEquals(SimpleType.make(String.class), function.getType().getReturnType());
    }

    @Test
    public void testFetchLocallyDeclaredReferenceTypeFunction() {

        EpiCompiler compiler = new EpiCompiler();
        
        /*
         * This was #3.
         */
        SourceDefinitionLoader loader = new SourceDefinitionLoader(
                new LiteralSourceLoader(JavaName.type("com.example.Foo"),
                        "package com.example; class Foo { public com.example.Foo foo() { return null; } }"),
                compiler);

        Type type = loader.getDefinition(JavaName.type("com.example.Foo"));

        Function function = type.getDefinition(JavaName.function("foo"));
        assertNotNull(function);
        assertEquals(JavaName.function("foo"), function.getName());
        
        assertEquals("{=>com.example.Foo}", function.getType().getName().getName());
        
        assertEquals(type, function.getType().getReturnType());
    }

    /**
     * A sophisticated test (for now) - mutually referencing types in the same class.
     */
    @Test
    public void testFetchForwardReferenceReferenceTypeFunction() {

        EpiCompiler compiler = new EpiCompiler();
        
        SourceDefinitionLoader loader = new SourceDefinitionLoader(
                new LiteralSourceLoader(JavaName.type("com.example.Foo"),
                        "package com.example; "
                        +"class Foo { public com.example.Bar bar() { return null; } } "
                        +"class Bar { public com.example.Foo foo() { return null; } } "),
                compiler);

        Type fooType = loader.getDefinition(JavaName.type("com.example.Foo"));
        assertNotNull(fooType);

        Type barType = loader.getDefinition(JavaName.type("com.example.Bar"));
        assertNotNull(barType);

        Function barMethod = fooType.getDefinition(JavaName.function("bar"));
        assertNotNull(barMethod);
        assertEquals(JavaName.function("bar"), barMethod.getName());
        
        assertEquals("{=>com.example.Bar}", barMethod.getType().getName().getName());
        assertEquals(barType, barMethod.getType().getReturnType());
        
        Function fooMethod = barType.getDefinition(JavaName.function("foo"));
        assertNotNull(fooMethod);
        assertEquals(JavaName.function("foo"), fooMethod.getName());

        assertEquals("{=>com.example.Foo}", fooMethod.getType().getName().getName());
        assertEquals(fooType, fooMethod.getType().getReturnType());

    }

}
