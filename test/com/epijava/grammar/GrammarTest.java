/*
 * 
 */
package com.epijava.grammar;

import static com.epijava.grammar.GrammarAssert.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.epijava.grammar.packrat.*;
import com.epijava.util.CodePoint;

/**
 * 
 * 
 */
public class GrammarTest extends UserGrammar {
    
    @Test
    public void testWhitespace() {
        // battery of tests for required whitespace
        assertMatch(S(), " ", ParseResult.toResult(" "));
        assertMatch(S(), " \t\n\r", ParseResult.toResult(" \t\n\r"));
//        assertMatch(S(), "\u000C", ParseResult.toResult("\u000C"));
        
        assertNoMatch(S(), "x", 0, S(), CodePoint.valueOf('x'));
        assertNoMatch(S(), Arrays.asList("foo"), 0, 0, S(), "foo");
      
        // battery of tests for optional whitespace (everything matches!)
        assertMatch(optS(), " ", ParseResult.toResult(" "));
        assertMatch(optS(), " \t\n\r", ParseResult.toResult(" \t\n\r"));
//        assertMatch(optS(), "\u000C", ParseResult.toResult("\u000C"));
        assertMatch(optS(), "", ParseResult.toResult(""));
        assertMatch(optS(), "x", ParseResult.toResult(""));
        assertMatch(optS(), Arrays.asList("foo"), ParseResult.toResult(""));
        
        // ensure that inverting a grammar is identical to the original
        Grammar s = S();
        assertEquals(s, s.inverse());
        
        Grammar opts = optS();
        assertEquals(opts, opts.inverse());
        
        // test toString() behavior
        assertEquals("whitespace", S().toString());
        assertEquals("optional whitespace", optS().toString());
        
        // test build behavior
        assertMatch(empty().wrap(S()), "", CodePoint.valueOf(' '));
        assertMatch(empty().wrap(optS()), "", ParseResult.toResult(""));
        
        assertEquals(CodePoint.valueOf(' '), S().generator().generate());
        assertEquals(ParseResult.toResult(""), optS().generator().generate());

    }
    
    @Test
    public void testWhitespaceParseEmptyString() {
        assertNoMatch(S(), "", 0, S(), ParseFailure.EOF);
    }
    
    @Test
    public void testEmpty() {
        assertMatch(empty(), "", Collections.EMPTY_LIST);
        assertMatch(empty(), "foo", Collections.EMPTY_LIST);
        
        // test inverse behavior
        Grammar empty = empty();
        assertSame(empty, empty.inverse());
        
        // test seq() optimization
        Grammar s = S();
        assertSame(s, empty().seq(s));
        
        // test toString behavior
        assertEquals("()", empty().toString());
        
        // test build behavior
        assertMatch(empty().wrap(empty()), "", Collections.EMPTY_LIST);
    }
    
    @Test
    public void testEof() {
        assertMatch(eof(), "", Collections.EMPTY_LIST);
        assertNoMatch(eof(), "a", 0, eof(), CodePoint.valueOf('a'));
        
        assertEquals("EOF", eof().toString());
        
        Grammar eof = eof();
        assertSame(eof.inverse(), eof);
        
        assertMatch(empty().wrap(eof()), "", Collections.EMPTY_LIST);
    }
    
    @Test
    public void testConstant() {
        // non-null value basic match
        assertMatch(constant("foo"), Arrays.asList("foo"), "foo");
        
        // non-null no match conditions
        assertNoMatch(constant("foo"), Collections.EMPTY_LIST, 0, 0, constant("foo"), ParseFailure.EOF);
        assertNoMatch(constant("foo"), Arrays.asList("bar"), 0, 0, constant("foo"), "bar");
        assertNoMatch(constant("foo"), "foo", 0, constant("foo"), CodePoint.valueOf('f'));
        
        // null value basic match
        assertMatch(constant(null), Arrays.asList((Object)null), null);
        
        // null no match
        assertNoMatch(constant(null), Arrays.asList((Object)"foo"), 0, 0, constant(null), "foo");
        
        // inverse
        Grammar c = constant("foo");
        assertSame(c, c.inverse());
        
        // test toString
        assertEquals("\"foo\"", constant("foo").toString());
        assertEquals("32", constant(32).toString());
        assertEquals("' '", ch(' ').toString());
        
        // test build behavior
        assertMatch(empty().wrap(constant("foo")), "", "foo");
    }
    
    @Test
    public void testSeq() {
        assertMatch(ch('a').seq(ch('b')), "ab", ParseResult.toResult("ab"));
        
        assertNoMatch(ch('a').seq(ch('b')), "ac", 1, ch('b'), CodePoint.valueOf('c'));
        assertNoMatch(ch('a').seq(ch('b')), "bb", 0, ch('a'), CodePoint.valueOf('b'));
        
        assertEquals("('a' 'b')", ch('a').seq(ch('b')).toString());
        
        assertMatch(empty().wrap(ch('a').seq(ch('b'))), "", ParseResult.toResult("ab"));
        
        // inverse should work the same.
        assertMatch(ch('a').seq(ch('b')).inverse(), "ab", ParseResult.toResult("ab"));
        assertNoMatch(ch('a').seq(ch('b')).inverse(), "ac", 1, ch('b'), CodePoint.valueOf('c'));
        assertNoMatch(ch('a').seq(ch('b')).inverse(), "bb", 0, ch('a'), CodePoint.valueOf('b'));  
        // XXX not testing for inverse builds or inverse sub-grammars working out.
    }
    
    @Test
    public void test3Seq() {
        assertMatch(ch('a').seq(ch('b')).seq(ch('c')), "abc", ParseResult.toResult("abc"));
        assertMatch(ch('a').seq(ch('b').seq(ch('c'))), "abc", ParseResult.toResult("abc"));
        assertMatch(ch('a').seq(ch('x')).seq(ch('b').seq(ch('c'))), "axbc", ParseResult.toResult("axbc"));

    }
    
    @Test
    public void testWrap() {
        // wraps one with another.
        assertMatch(ch('a').wrap(ch('b')), "a", CodePoint.valueOf('b'));
        
        assertNoMatch(ch('x').wrap(ch('b')), "a", 0, ch('x'), CodePoint.valueOf('a'));
        
        
        assertMatch(ch('a').wrap(ch('b')).inverse(), "b", CodePoint.valueOf('a'));
    }
    
    @Ignore // XXX this is an odd case, we're not sure if we want it at all.
    @Test(expected=UnsupportedOperationException.class)
    public void testNestedWrap() {
        // wraps nested in build expressions not allowed.
        // looks like not covered line, but really it worked: it's a weirdism of JUnit.
        Object o = empty().wrap(empty().wrap(ch('c'))).parser().parse("foo");
        System.out.println(o);
    }
    
    @Test
    public void testLabelsAndRefs() {
        assertMatch(ch('a').label("A").wrap(ref("A").seq(ch('b'))), "a", ParseResult.toResult("ab"));
        assertNoMatch(ch('a').label("A"), "x", 0, ch('a'), CodePoint.valueOf('x'));
        
        assertEquals("A='a'", ch('a').label("A").toString());
        assertEquals("A", ref("A").toString());
    }
    
    @Test
    public void testInverseLabelsAndRefs() {
        assertMatch(ch('a').label("A").wrap(ref("A").seq(ch('b'))).inverse(), "ab", CodePoint.valueOf('a'));
    }
    
    @Test(expected=AssertionError.class)
    public void testLabelNotFound() {
        empty().wrap(ref("Foo")).parser().parse("Foo");
    }
    
    @Test(expected=AssertionError.class)
    public void testLabelNotFoundInInverse() {
        empty().wrap(ref("Foo")).inverse();
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testLabelInBuild() {
        empty().wrap(ch('a').label("Foo")).parser().parse("Foo");
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testRefInParse() {
        ref("Foo").parser().parse("Foo");
    }
    
    @Test(expected=NullPointerException.class)
    public void testNullLabel() {
        ch('a').label(null);
    }
    
    @Test
    public void testNullRef() {
        try {
            ref(null);
            fail();
        } catch (NullPointerException ex) {
            // expected.
        }
    }
    
    
    @Test
    public void testObj() {
        assertMatch(obj(), Arrays.asList("Foo"), "Foo");

        assertMatch(obj(SimpleString.class), Arrays.asList(new SimpleString()), new SimpleString());
        assertNoMatch(obj(SimpleString.class), "", 0, obj(SimpleString.class), ParseFailure.EOF);
        assertNoMatch(obj(SimpleString.class), "f", 0, obj(SimpleString.class), CodePoint.valueOf('f'));
        
        assertMatch(obj(SimpleString.class, prop("v", constant("Foo"))), 
                Arrays.asList(new SimpleString("Foo")), new SimpleString("Foo"));

        
        assertNoMatch(obj(SimpleString.class, prop("v", constant("Foo"))), 
                Arrays.asList(new SimpleString("Bar")), 1, 0, constant("Foo"), "Bar");
        
        assertEquals("com.epijava.grammar.GrammarTest$SimpleMult(lhs:\"Foo\", rhs:\"Bar\")", 
                obj(SimpleMult.class, prop("lhs", constant("Foo")), prop("rhs", constant("Bar"))).toString());
        
        assertMatch(obj(SimpleString.class, prop("v", constant("Foo")))
                .wrap(obj(SimpleString.class, prop("v", constant("Bar")))),
                Arrays.asList(new SimpleString("Foo")), new SimpleString("Bar"));
        
        assertMatch(obj(SimpleString.class, prop("v", constant("Foo")))
                .wrap(obj(SimpleString.class, prop("v", constant("Bar")))).inverse(),
                Arrays.asList(new SimpleString("Bar")), new SimpleString("Foo"));

        assertMatch(obj(SimpleString.class, prop("v", obj().label("P")))
                .wrap(obj(SimpleString.class, prop("v", ref("P")))),
                Arrays.asList(new SimpleString("Foo")), new SimpleString("Foo"));
    }
    
    @Test(expected=NullPointerException.class)
    public void testNullObjStuff() {
        obj(null);
    }
    
    @Test(expected=AssertionError.class)
    public void testNullPropName() {
        prop(null, empty());
    }
    
    @Test(expected=NullPointerException.class)
    public void testNullPropGrammar() {
        prop("Foo", null);
    }
    
    @Test(expected=AssertionError.class)
    public void testRebindProp() {
        Property prop = prop("Foo", empty());
        obj(Object.class, prop);
        obj(Object.class, prop);
        
    }
    
    @Test
    public void testOr() {
        assertMatch(ch('a').or(ch('b')), "a", CodePoint.valueOf('a'));
        assertMatch(ch('a').or(ch('b')), "b", CodePoint.valueOf('b'));

        // XXX this error message will probably change (expected should be a|b
        assertNoMatch(ch('a').or(ch('b')), "c", 0, ch('a').or(ch('b')), CodePoint.valueOf('c'));
    
        
        assertMatch(ch('a').or(ch('b')).inverse(), "a", CodePoint.valueOf('a'));
        assertMatch(ch('a').or(ch('b')).inverse(), "b", CodePoint.valueOf('b'));

        // XXX this error message will probably change (expected should be a|b
        assertNoMatch(ch('a').or(ch('b')).inverse(), "c", 0, ch('a').or(ch('b')), CodePoint.valueOf('c'));

        assertMatch(ch('a').or(ch('b')).seq(ch('c')), "ac", ParseResult.toResult("ac"));
        assertMatch(ch('a').or(ch('b')).seq(ch('c')), "bc", ParseResult.toResult("bc"));
        
        assertEquals("('a' | 'b')", ch('a').or(ch('b')).toString());
    }
    
    @Test(expected=AmbiguousGrammarException.class)
    public void testOrBuild() {
        empty().wrap(ch('a').or(ch('b'))).parser().parse("");
    }
    
    @Test
    public void testRule() {
        assertMatch(ch('a').rule("A"), "a", CodePoint.valueOf('a'));
        assertNoMatch(ch('a').rule("A"), "b", 0, ch('a').rule("A"), CodePoint.valueOf('b'));
        
        assertMatch(ch('a').rule("A").inverse(), "a", CodePoint.valueOf('a'));
        assertNoMatch(ch('a').rule("A").inverse(), "b", 0, ch('a').rule("A"), CodePoint.valueOf('b'));
        
        assertEquals("A", ch('a').rule("A").toString());
//        assertEquals("rule A { 'a' }", ch('a').rule("A").toString());

        assertMatch(empty().wrap(ch('a').rule("A")), "", CodePoint.valueOf('a'));
    }
    
    @Test
    public void testRecurse() {
        // rule A { recurse("A") 'x' / 'x' }
        
        assertMatch(recurse("A").seq(ch('x')).or(ch('x')).rule("A"), "xxx", ParseResult.toResult("xxx"));
        
        assertMatch(recurse("A").seq(ch('x')).or(ch('x')).rule("A").inverse(), "xxx", ParseResult.toResult("xxx"));

        assertEquals("recurse(\"X\")", recurse("X").toString());
    }
    
    @Test(expected=NullPointerException.class)
    public void testBuildRecurse() {
        empty().wrap(recurse("A")).parser().parse("");
    }
    
    
    @Test
    public void testAsString() {
        assertMatch(ch('a').seq(ch('b')).asString(), "ab", "ab");
        assertNoMatch(ch('a').seq(ch('b')).asString(), "ac", 1, ch('b'), CodePoint.valueOf('c'));
        
        assertMatch(ch('a').seq(ch('b')).asString().inverse(), Arrays.asList("ab"), ParseResult.toResult("ab"));
        
        // XXX is this appropriate!?
//        assertMatch(empty().wrap(ch('a').seq(ch('b')).asString()), "", "ab");
        
        assertEquals("('a' 'b').wrap(com.epijava.grammar.fn.ListOfIntegersToStringFn)",
                ch('a').seq(ch('b')).asString().toString());
    }
    
    @Test
    public void testConvenienceMethods() {
        assertMatch(any(), "a", CodePoint.valueOf('a'));
        assertNoMatch(any(), "", 0, any(), ParseFailure.EOF);
        
        assertMatch(ch('a', 'm'), "a", CodePoint.valueOf('a'));
        assertMatch(ch('a', 'm'), "l", CodePoint.valueOf('l'));
        assertMatch(ch('a', 'm'), "m", CodePoint.valueOf('m'));
        assertNoMatch(ch('a', 'm'), "o", 0, ch('a', 'm'), CodePoint.valueOf('o'));

        assertMatch(str("Hello"), "Hello", ParseResult.toResult("Hello"));
        assertNoMatch(str("Hello"), "Help", 3, ch('l'), CodePoint.valueOf('p'));

        assertMatch(ch('a').star(), "aaa", ParseResult.toResult("aaa"));
        assertMatch(ch('a').star().asString(), "aaa", "aaa");
        assertMatch(ch('a').star(), "", ParseResult.toResult(""));
        assertNoMatch(ch('a').star().seq(eof()), "aaab", 3, eof(), CodePoint.valueOf('b'));
        assertNoMatch(ch('a').star().seq(eof()), "b", 0, eof(), CodePoint.valueOf('b'));

        
        assertMatch(ch('a').plus(), "aaa", ParseResult.toResult("aaa"));
        assertMatch(ch('a').plus().asString(), "aaa", "aaa");
        assertNoMatch(ch('a').plus(), "", 0, ch('a'), ParseFailure.EOF);
        assertNoMatch(ch('a').plus().seq(eof()), "aaab", 3, eof(), CodePoint.valueOf('b'));
        assertNoMatch(ch('a').plus().seq(eof()), "b", 0, ch('a'), CodePoint.valueOf('b'));
        
        assertMatch(ch('a').opt(), "a", CodePoint.valueOf('a'));
        assertMatch(ch('a').opt(), "", Collections.EMPTY_LIST);
        assertNoMatch(ch('a').opt().seq(eof()), "ab", 1, eof(), CodePoint.valueOf('b'));
        assertNoMatch(ch('a').opt().seq(eof()), "b", 0, eof().or(ch('a')), CodePoint.valueOf('b'));
    }
    
    @Test
    public void testRandomParsingA() {
        testRandomParsing(ch('a').or(ch('b')).seq(eof()), 10);
    }
    
    @Test
    public void testRandomParsingB() {
        testRandomParsing(str("hello").or(str("goodbye")).seq(eof()), 10);
    }
    
    @Test
    public void testRandomParsingC() {
        testRandomParsing(ch('a').star().seq(eof()), 10);
    }

    @Test
    public void testRandomParsingD() {
        testRandomParsing(ch('a').plus().seq(eof()), 10);
    }
    
    @Test
    public void testRandomParsingZ() {
        testRandomParsing(ch('a').plus().or(ch('b').star()).seq(eof()), 100);
    }
    
    @Test
    public void testRandomParsingE() {
        testRandomParsing(str("foo").plus().or(ch('a', 'z').star()).seq(eof()), 100);
    }

    private static void testRandomParsing(Grammar g, int n) {
        System.out.println(g);
        Generator gen = g.generator().setOrGenerator(new OrGenerator.Random());
        
        for (int i=0; i<n; i++) {
            Object generated = gen.generate();
            System.out.print("  "+generated);
            try {
                Object parsed = g.parser().parse(generated);
                System.out.println(" -> "+parsed);
            } catch (GrammarParseException ex) {
                System.out.println(" -> "+ex.getMessage());
                throw (AssertionError)new AssertionError("Grammar "+g+" could not parse "+generated)
                .initCause(ex);
            }
        }
    }
    
    @Test
    public void testShortestPath() {

        /*
         * This is an odd case: PEGs (Parsing Expression Grammars) are greedy.
         * So the first match has to be the longest match.
         * 
         * In this case, the grammar is really ill-formed. "b" cannot ever be
         * matched.
         * 
         * This creates a problem for our framework: GENERATING this grammar
         * will generate things that can never be parsed.
         * 
         * Not a huge deal, but kindof irritating.
         */
        assertNoMatch(empty().or(ch('b')).seq(eof()), "b", 0, eof(), CodePoint.valueOf('b'));

        assertMatch(empty().or(ch('b')).seq(eof()), "", ParseResult.toResult(""));

    }


    // ----------------------------------------------------------------------
    // Legacy Tests

    @Test
    public void testSimpleGrammarA() {
        assertMatch(empty(), "abcdefg", Collections.EMPTY_LIST);
    }

    @Test
    public void testSimpleGrammarB() {
        assertMatch(ch('a'), "a", CodePoint.valueOf('a'));
    }

    @Test
    public void testSimpleGrammarC() {
        assertMatchWholeInputStream(str("abcdefg"), "abcdefg", ObjectStream
                .make("abcdefg").toSemanticValue());
    }

    @Test
    public void testSimpleGrammarD() {
        assertMatch(str("abc"), "abcdefg", ObjectStream.make("abc")
                .toSemanticValue());
    }

    @Test
    public void testFailE() {
        assertNoMatch(str("abcX"), "abcdefg", 3, ch('X'), CodePoint.valueOf('d'));
    }

    @Test
    public void testSimpleGrammarF() {
        assertMatchWholeInputStream(str("abc").seq(empty()).seq(str("defg")),
                "abcdefg", ObjectStream.make("abcdefg").toSemanticValue());
    }

    @Test
    public void testSimpleGrammarG() {
        assertMatchWholeInputStream(ch('a').star(), "aaaa", ObjectStream
                .make("aaaa").toSemanticValue());

    }

    @Test
    public void testObjectGrammar() {
        // match a Throwable with a null cause.
        Grammar f = obj(Throwable.class, prop("cause", nil()));
        Throwable t = new ArrayIndexOutOfBoundsException().initCause(null);
        assertMatch(f, Arrays.asList(t), t);

        NullPointerException npe = new NullPointerException();
        Throwable t2 = new AssertionError()
        .initCause(npe);
        assertNoMatch(f, Arrays.asList(t2), 1, 0, constant(null), npe);

        assertMatch(obj(Throwable.class, prop("cause", obj())), Arrays
                .asList(t2), t2);

    }

    @Test
    public void testRefGet() {
        assertMatch(ch('a').label("A").wrap(ref("A").seq(ref("A"))), "a",
                ObjectStream.make("aa").toSemanticValue());
    }

    @Test
    public void testMoreComplicatedRefGet() {
        assertMatch(ch('a').label("A").seq(ch('b').label("B")).wrap(
                ref("B").seq(ref("A"))), "ab", ObjectStream.make("ba")
                .toSemanticValue());
    }

    @Test(expected = AmbiguousGrammarException.class)
    public void testBadWrap() {
        // this is an example where we might want to make an OR expression illegal in a wrap expression.
        assertMatch(ch('a').label("A").seq(ch('b').label("B")).wrap(
                ref("B").star()), // star is bad in a wrap() expression!
                "ab", ObjectStream.make("ba").toSemanticValue());
    }

    @Test
    public void testObjectCreation() {
        assertMatch(
                constant(32).label("A").seq(constant(202020).label("B")).wrap(
                        obj(Person.class, prop("age", ref("A")), prop("id",
                                ref("B")))), Arrays.asList(32, 202020), new Person().setAge(32)
                                .setId(202020));
    }

    @Test
    public void testInverseObjectCreation() {

        // A='a' B='b' -> new Person(age:A, id:B)

        // inverse is...

        // Person(age:A='a', id:B='b') -> A B        

        assertMatch(obj(Person.class, prop("age", constant(32).label("A")),
                prop("id", constant(202020).label("B"))).wrap(ref("A").seq(ref("B"))),
                Arrays.asList(new Person().setAge(32).setId(202020)),
                Arrays.asList(32, 202020));
    }

    @Test
    public void testInverseOperator() {

        // A='a' B='b' -> new Person(age:A, id:B)

        // inverse is...

        // Person(age:A='a', id:B='b') -> A B        

        Grammar g = constant(32).label("A").seq(constant(202020).label("B")).wrap(
                obj(Person.class, prop("age", ref("A")), prop("id", ref("B"))));
        Grammar gInv = g.inverse();
        assertMatch(gInv, Arrays.asList(new Person().setAge(32).setId(202020)),
                Arrays.asList(32, 202020));
    }

    @Test
    @SuppressWarnings("unused")
    public void testSomeInverses() {
        Grammar a = ch('a').star().label("AStar").wrap(
                obj(Person.class, prop("foo", ref("AStar"))));
        Grammar aInv = a.inverse();
        Grammar aInvInv = a.inverse().inverse();

        // this one's not quite right....
        Grammar b = ch('a').seq(ch('b').label("B")).wrap(
                obj(Person.class, prop("foo", ref("B"))));
        Grammar bInv = b.inverse();
        Grammar bInvInv = b.inverse().inverse();

        // this one's not quite right....
        Grammar c = ch('a').seq(ch('b').label("B")).wrap(
                obj(Person.class, prop("foo", obj(Person.class, prop("foo",
                        ref("B"))))));
        Grammar cInv = c.inverse();
        Grammar cInvInv = c.inverse().inverse();

        System.out.println();
    }

    @Test
    public void testSimpleLang() {
        assertMatch(new SimpleLang(false), "2         + 2", Arrays
                .asList(new SimplePlus("2", "2")));
    }

    @Test
    public void testRecursiveSimpleLang() {
        assertMatch(new SimpleLang(true), "2 + 2 + 2", Arrays
                .asList(new SimplePlus("2", new SimplePlus("2", "2"))));

        assertMatch(new SimpleLang(true), "2 * 2 + 2", Arrays
                .asList(new SimpleMult("2", new SimplePlus("2", "2"))));
    }

    @Test
    public void testInverseSimpleLang() {

        assertMatch(new SimpleLang(false).inverse(), Arrays
                .asList(new SimpleMult("2", "2")), ParseResult.toResult("2* 2"));
    }

    /**
     * A simple arithmetic expression language
     * 
     *
     */
    public static class SimpleLang extends UserGrammar {

        private final boolean recursive;

        public SimpleLang(boolean _recursive) {
            recursive = _recursive;
        }

        @Override
        public Grammar main() {
            return expr().seq(eof());
        }

        public Grammar expr() {
            return plus().or(mult()).or(number()).rule("expr");
        }

        public Grammar terminal() {
            if (recursive)
                return recurse("expr");
            else
                return number();
        }

        public Grammar number() {
            return ch('0', '9').plus().asString().label("Number").wrap(
                    obj(SimpleString.class, prop("v", ref("Number")))).rule(
                    "number");
        }

        public Grammar plus() {
            return terminal().label("LHS").seq(optS()).seq(ch('+')).seq(optS()).seq(
                    terminal().label("RHS")).wrap(
                            obj(SimplePlus.class, prop("lhs", ref("LHS")), prop("rhs",
                                    ref("RHS")))).rule("plus");
        }

        public Grammar mult() {
            return terminal().label("LHS").seq(optS()).seq(ch('*')).seq(S()).seq(
                    terminal().label("RHS")).wrap(
                            obj(SimpleMult.class, prop("lhs", ref("LHS")), prop("rhs",
                                    ref("RHS")))).rule("mult");
        }
    }

    public static class SimpleExpr {

    }

    public static class SimpleString extends SimpleExpr {
        private Object v;

        public SimpleString() {
        }

        public SimpleString(String _v) {
            v = _v; 
//          v = ObjectStream.make(_v).toSemanticValue();
        }

        public Object getV() {
            return v;
        }

        public void setV(Object v) {
            this.v = v;
        }

        @Override
        public String toString() { return "SimpleString("+v+")"; }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((v == null) ? 0 : v.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final SimpleString other = (SimpleString) obj;
            if (v == null) {
                if (other.v != null)
                    return false;
            } else if (!v.equals(other.v))
                return false;
            return true;
        }
    }

    public static class SimplePlus extends SimpleExpr {
        private SimpleExpr lhs;
        private SimpleExpr rhs;

        public SimplePlus() {
        }

        public SimplePlus(SimpleExpr _lhs, SimpleExpr _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimplePlus(String _lhs, String _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimplePlus(String _lhs, SimpleExpr _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimplePlus(SimpleExpr _lhs, String _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimpleExpr getLhs() {
            return lhs;
        }

        public SimplePlus setLhs(SimpleExpr lhs) {
            this.lhs = lhs;
            return this;
        }

        public SimplePlus setLhs(String v) {
            return setLhs(new SimpleString(v));
        }

        public SimpleExpr getRhs() {
            return rhs;
        }

        public SimplePlus setRhs(String v) {
            return setRhs(new SimpleString(v));
        }

        public SimplePlus setRhs(SimpleExpr rhs) {
            this.rhs = rhs;
            return this;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
            result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final SimplePlus other = (SimplePlus) obj;
            if (lhs == null) {
                if (other.lhs != null)
                    return false;
            } else if (!lhs.equals(other.lhs))
                return false;
            if (rhs == null) {
                if (other.rhs != null)
                    return false;
            } else if (!rhs.equals(other.rhs))
                return false;
            return true;
        }
    }

    public static class SimpleMult extends SimpleExpr {
        private SimpleExpr lhs;
        private SimpleExpr rhs;

        public SimpleMult() {
        }

        public SimpleMult(SimpleExpr _lhs, SimpleExpr _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimpleMult(String _lhs, String _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimpleMult(String _lhs, SimpleExpr _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimpleMult(SimpleExpr _lhs, String _rhs) {
            setLhs(_lhs);
            setRhs(_rhs);
        }

        public SimpleExpr getLhs() {
            return lhs;
        }

        public SimpleMult setLhs(SimpleExpr lhs) {
            this.lhs = lhs;
            return this;
        }

        public SimpleMult setLhs(String v) {
            return setLhs(new SimpleString(v));
        }

        public SimpleExpr getRhs() {
            return rhs;
        }

        public SimpleMult setRhs(String v) {
            return setRhs(new SimpleString(v));
        }

        public SimpleMult setRhs(SimpleExpr rhs) {
            this.rhs = rhs;
            return this;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((lhs == null) ? 0 : lhs.hashCode());
            result = prime * result + ((rhs == null) ? 0 : rhs.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final SimpleMult other = (SimpleMult) obj;
            if (lhs == null) {
                if (other.lhs != null)
                    return false;
            } else if (!lhs.equals(other.lhs))
                return false;
            if (rhs == null) {
                if (other.rhs != null)
                    return false;
            } else if (!rhs.equals(other.rhs))
                return false;
            return true;
        }
    }

//  @Ignore
//  // these cases don't operate yet.
//  @Test
//  public void testGrammarConstruction() {
//  TestLang testLang = new TestLang();

//  Expr expr = (Expr) testLang.parser().parse("a == b");

//  Printer printer = testLang.printer();

//  printer.setPrintRules(new PrintRules().rule("beforeOp.eq", newline()
//  .indent(2)));

//  assertEquals("a == b", printer.printToString(expr));
//  }

//  static class TestLang extends UserGrammar {

//  public Grammar main() {
//  return expr();
//  }

//  Grammar expr() {
//  return equalsOp().or(varRef());
//  }

//  Grammar equalsOp() {
//  return expr().label("lhs").seq(empty().label("beforeOp.eq")).seq(
//  EQEQ()).seq(empty().label("afterOp.eq")).seq(
//  expr().label("rhs"))

//  .wrap(obj(EqualsOp.class));
//  }

//  Grammar varRef() {
//  return ID().label("name")

//  .wrap(obj(VarRef.class));
//  }

//  Grammar ifExpr() {
//  return IF().seq(LPAR()).seq(expr()).seq(RPAR()).seq(block())

//  .wrap(obj(If.class));
//  }

//  Grammar block() {
//  return LCURL().seq(expr()).seq(RCURL())

//  .wrap(obj(Block.class));
//  }

//  // --- some tokens

//  Grammar LPAR() {
//  return (ch('('));
//  }

//  Grammar RPAR() {
//  return (ch(')'));
//  }

//  Grammar LCURL() {
//  return (ch('{'));
//  }

//  Grammar RCURL() {
//  return (ch('}'));
//  }

//  Grammar EQEQ() {
//  return (str("=="));
//  }

//  Grammar KEYWORD() {
//  return IF().or(VOID()).or(PUBLIC());
//  }

//  Grammar IF() {
//  return (str("if"));
//  }

//  Grammar VOID() {
//  return (str("void"));
//  }

//  Grammar PUBLIC() {
//  return (str("public"));
//  }

//  Grammar ID() {
//  return empty().notFollowedBy(KEYWORD()).seq(
//  (str("[a-zA-Z_][a-zA-Z0-9_]*")));
//  }

//  }

//  public static class Token {
//  }

//  public static class KeywordToken extends Token {
//  private final String keyword;

//  public KeywordToken(String _keyword) {
//  keyword = _keyword;
//  }

//  public String getKeyword() {
//  return keyword;
//  }
//  }

//  public static class IdToken extends Token {
//  private final String id;

//  public IdToken(String _id) {
//  id = _id;
//  }

//  public String getId() {
//  return id;
//  }
//  }

//  public static class Expr {
//  }

//  public static class VarRef extends Expr {
//  }

//  public static class EqualsOp extends Expr {
//  Expr lhs;
//  Expr rhs;

//  }

//  public static class If extends Expr {
//  }

//  public static class Block extends Expr {
//  }

    public static class Person {
        private int age;
        private int id;
        private Object foo;

        public int getAge() {
            return age;
        }

        public Person setAge(int age) {
            this.age = age;
            return this;
        }

        public int getId() {
            return id;
        }

        public Person setId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((foo == null) ? 0 : foo.hashCode());
            result = prime * result + id;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final Person other = (Person) obj;
            if (age != other.age)
                return false;
            if (foo == null) {
                if (other.foo != null)
                    return false;
            } else if (!foo.equals(other.foo))
                return false;
            if (id != other.id)
                return false;
            return true;
        }

        public Object getFoo() {
            return foo;
        }

        public void setFoo(Object foo) {
            this.foo = foo;
        }

    }
}
