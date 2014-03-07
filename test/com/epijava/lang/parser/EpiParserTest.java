/*
 * 
 */
package com.epijava.lang.parser;

import static com.epijava.util.unify.UnifyTerm.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.epijava.lang.test.*;
import com.epijava.lang.tree.*;
import com.epijava.util.*;
import com.epijava.util.unify.*;

/**
 * Test the parser
 * 
 */
public class EpiParserTest extends EpiTestCase {

    @Test
    public void testParserInvocation() throws EpiParseException {
        CompilationUnit cu = new EpiParser()
                .parseLiteralSource("public class Foo {}");
        assertEquals(1, cu.getTypes().size());
    }

    @Test(expected = EpiParseException.class)
    public void testParseException() throws EpiParseException {
        new EpiParser().parseLiteralSource("class public Foo {}");
    }

    @Test
    public void testPackageDeclaration() throws EpiParseException {
        CompilationUnit expr = new EpiParser()
                .parseLiteralSource("package com.example.foo;");
        assertEquals(new QualifiedName("com", "example", "foo"), expr
                .getPackageName());
    }

    @Test
    public void testSimpleImports() throws EpiParseException {
        CompilationUnit expr = new EpiParser()
                .parseLiteralSource("import com.example.*; import static com.example.Person.*; import com.example.Person; import static com.example.Person.Name;");
        assertEquals(4, expr.getImports().size());

        Import i;
        i = expr.getImports().get(0);
        assertTrue(i.isImportAll());
        assertFalse(i.isStaticImport());
        assertEquals(new QualifiedName("com", "example"), i.getName());

        i = expr.getImports().get(1);
        assertTrue(i.isImportAll());
        assertTrue(i.isStaticImport());
        assertEquals(new QualifiedName("com", "example", "Person"), i.getName());

        i = expr.getImports().get(2);
        assertFalse(i.isImportAll());
        assertFalse(i.isStaticImport());
        assertEquals(new QualifiedName("com", "example", "Person"), i.getName());

        i = expr.getImports().get(3);
        assertFalse(i.isImportAll());
        assertTrue(i.isStaticImport());
        assertEquals(new QualifiedName("com", "example", "Person", "Name"), i
                .getName());
    }

    @Test
    public void testParseType() throws EpiParseException {
        CompilationUnit cu = new EpiParser()
                .parseLiteralSource("public class Foo {}");
        assertEquals(1, cu.getTypes().size());
        assertEquals("Foo", cu.getTypes().get(0).getName());
    }

    @Test
    public void testParseSuperAndInterfaces() throws EpiParseException {
        CompilationUnit cu = new EpiParser()
                .parseLiteralSource("public class Foo extends Bar implements Baz, Bux{}");
        assertEquals(1, cu.getTypes().size());
        ClassDeclaration c = (ClassDeclaration) cu.getTypes().get(0);

        // check super
        assertEquals(new NamedTypeReference(null, "Bar"), c.getSuperType());

        // check interfaces
        assertEquals(2, c.getInterfaces().size());
        assertEquals(new NamedTypeReference(null, "Baz"), c.getInterfaces().get(0));
        assertEquals(new NamedTypeReference(null, "Bux"), c.getInterfaces().get(1));
    }

    @Test
    public void testBlockMembers() throws EpiParseException {
        CompilationUnit cu = new EpiParser()
                .parseLiteralSource("public class Foo { {} static{} }");
        ClassDeclaration c = (ClassDeclaration) cu.getTypes().get(0);

        assertEquals(2, c.getMembers().size());

        assertEquals(false, ((BlockMember) c.getMembers().get(0)).isStatic());
        assertEquals(true, ((BlockMember) c.getMembers().get(1)).isStatic());
    }

    @Test
    public void testBlockContainingBlocks() throws EpiParseException {
        CompilationUnit cu = new EpiParser()
                .parseLiteralSource("public class Foo { { {} {} } }");
        ClassDeclaration c = (ClassDeclaration) cu.getTypes().get(0);

        assertEquals(1, c.getMembers().size());

        assertEquals(false, ((BlockMember) c.getMembers().get(0)).isStatic());

        BlockMember classMember = ((BlockMember) c.getMembers().get(0));
        assertEquals(2, classMember.getStatement().getStatements().size());

        assertEquals(0, ((Block) classMember.getStatements().get(0))
                .getStatements().size());
        assertEquals(0, ((Block) classMember.getStatements().get(1))
                .getStatements().size());
    }

    @Test
    public void testTopLevelBlockContainingBlocks() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("{} {}");
        Block s = cu.getTopLevelStatements();

        assertEquals(2, s.getStatements().size());

        assertEquals(0, ((Block) s.getStatements().get(0))
                .getStatements().size());
        assertEquals(0, ((Block) s.getStatements().get(1))
                .getStatements().size());
    }

    @Test
    public void testTopLevelNull() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("null;");
        Block s = cu.getTopLevelStatements();

        assertEquals(1, s.getStatements().size());

        assertInstanceof(NullLiteral.class, s.getStatements().get(0));
    }

    @Test
    public void testTopLevelInt() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("42;");
        
        Match m = match(Block.class).field(
                        "statements",
                        list().get(0,
                                match(IntLiteral.class).field("value", var("X"))));

        UnifyBindings bindings = m.forceUnify(cu.getTopLevelStatements());
        assertEquals(42, bindings.get("X"));
    }


    @Test
    public void testTopLevelLong() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("42l; 43L;");

        Match m = match(Block.class).field(
                        "statements",
                        list().get(0,
                                match(LongLiteral.class).field("value", var("X")))
                              .get(1,
                                match(LongLiteral.class).field("value", var("Y"))));

        UnifyBindings bindings = m.forceUnify(cu.getTopLevelStatements());
        assertEquals(42L, bindings.get("X"));
        assertEquals(43L, bindings.get("Y"));
    }
    
    @Test
    public void testTopLevelLongWithParentheses() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("(42l); (43L);");

        Match m = match(Block.class).field(
                        "statements",
                        list().get(0,
                                match(LongLiteral.class).field("value", var("X")))
                              .get(1,
                                match(LongLiteral.class).field("value", var("Y"))));

        UnifyBindings bindings = m.forceUnify(cu.getTopLevelStatements());
        assertEquals(42L, bindings.get("X"));
        assertEquals(43L, bindings.get("Y"));
    }
    
    @Test
    public void testTopLevelReference() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("x.y.z;");

        Match m = match(Block.class).field(
                        "statements",
                        list().get(0,
                                match(AmbiguousReference.class).field("name", var("Name"))));

        UnifyBindings bindings = m.forceUnify(cu.getTopLevelStatements());
        assertEquals(new QualifiedName("x", "y", "z"),
                bindings.get("Name"));
    }

    @Test
    public void testReferenceInStaticInitializer() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("class T { static { x.y.z; } }");

        Match m = match(ClassDeclaration.class).field(
                "members",
                list().get(
                        0,
                        match(BlockMember.class).field(
                                "statements",
                                list().get(
                                        0,
                                        match(AmbiguousReference.class).field(
                                                "name", var("Name"))))));

        UnifyBindings bindings = m.forceUnify(cu.getTypes().get(0)); // XXX assert exactly one?
        assertEquals(new QualifiedName("x", "y", "z"),
                bindings.get("Name"));
    }
    
    @Test
    public void testTopLevelCall() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("x.y.z();");

        Match m = match(Block.class).field(
                "statements",
                list().get(
                        0,
                        match(Call.class)
                                .field("methodName", value("z"))
                                .field(
                                        "self",
                                        match(AmbiguousReference.class).field(
                                                "name", var("SelfName")))
                                .field("args", list().sizeEq(value(0)))));

        UnifyBindings bindings = m.forceUnify(cu.getTopLevelStatements());
        assertEquals(new QualifiedName("x", "y"),
                bindings.get("SelfName"));
    }
    
    @Test
    public void testTopLevelCallNoSelf() throws EpiParseException {
        CompilationUnit cu = new EpiParser().parseLiteralSource("z();");

        Match m = match(Block.class).field(
                "statements",
                list().get(
                        0,
                        match(Call.class)
                                .field("methodName", value("z"))
                                .field("self", value(null))
                                .field("args", list().sizeEq(value(0)))));

        m.forceUnify(cu.getTopLevelStatements());
        
    }

    private static void assertInstanceof(Class<?> class1, Object v) {
        if (!class1.isInstance(v))
            throw new AssertionError("Expected instance of " + class1.getName()
                    + ": got " + v.getClass().getName());

    }
}
