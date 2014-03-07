/*
 * 
 */
package com.epijava.grammar;

import static org.junit.Assert.*;

import org.junit.*;

import com.epijava.grammar.packrat.*;
import com.epijava.util.*;

/**
 * 
 * 
 */
public class GrammarGrammarTest {

    @Test
    public void testSimpleParse() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse("'a'");
        
        assertEquals(CodePoint.valueOf('a'), g.parser().parse("a"));
    }
    
    @Test
    public void testSeqParse() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse("'a' 'b'");

        assertEquals(ParseResult.toResult("ab"), g.parser().parse("ab"));
    }
    
    @Test
    public void testParenthesizedSeqParse() {
        GrammarGrammar grammarGrammar = new GrammarGrammar();
        Grammar g = (Grammar) grammarGrammar.parser().parse(
                "('a') 'b' 'c' ('d' 'e')");
        
        System.out.println(g);

        assertEquals(ParseResult.toResult("abcde"), g.parser().parse("abcde"));
    }
    
    
    @Test
    public void testOrParse() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse("'a' / 'b'");

        assertEquals(CodePoint.valueOf('a'), g.parser().parse("a"));
        assertEquals(CodePoint.valueOf('b'), g.parser().parse("b"));

    }
    
    @Test
    public void testParenthesizedOrParse() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse(
                "('a'/'b')/'c'/('d'/'e')");

        assertEquals(CodePoint.valueOf('a'), g.parser().parse("a"));
        assertEquals(CodePoint.valueOf('b'), g.parser().parse("b"));
        assertEquals(CodePoint.valueOf('c'), g.parser().parse("c"));
        assertEquals(CodePoint.valueOf('d'), g.parser().parse("d"));
        assertEquals(CodePoint.valueOf('e'), g.parser().parse("e"));

    }
    
    @Test
    public void testParenthesizedOrAndSeqParse() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse(
                "('a' 'b')/'c'/('d' 'e')");

        assertEquals(ParseResult.toResult("ab"), g.parser().parse("ab"));
        assertEquals(CodePoint.valueOf('c'), g.parser().parse("c"));
        assertEquals(ParseResult.toResult("de"), g.parser().parse("de"));

        assertEquals("'a' 'b'/'c'/'d' 'e'", new GrammarGrammar().inverse().asString().parser().parse(g));
    }
    
    @Test
    public void testPrecedence() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse(
                "'a' 'b' / 'c' / 'd' 'e'");

        assertEquals(ParseResult.toResult("ab"), g.parser().parse("ab"));
        assertEquals(CodePoint.valueOf('c'), g.parser().parse("c"));
        assertEquals(ParseResult.toResult("de"), g.parser().parse("de"));

        assertEquals("'a' 'b'/'c'/'d' 'e'", new GrammarGrammar().inverse().asString().parser().parse(g));
        
    }
    
    @Test
    public void testParenthesizedOrAndSeqParse2() {
        Grammar g = (Grammar)new GrammarGrammar().parser().parse(
                "'a' ('b'/'c') ('d'/'e')");

        assertEquals(ParseResult.toResult("abd"), g.parser().parse("abd"));
        assertEquals(ParseResult.toResult("abe"), g.parser().parse("abe"));
        assertEquals(ParseResult.toResult("acd"), g.parser().parse("acd"));
        assertEquals(ParseResult.toResult("ace"), g.parser().parse("ace"));

        assertEquals("'a' ('b'/'c') ('d'/'e')", new GrammarGrammar().inverse().asString().parser().parse(g));
    }
    
    @Test
    public void testPrecedence2() {
        Grammar g = (Grammar) new GrammarGrammar().parser().parse(
                "'a' ((('b'/'c')) ('d'/'e'))");

        assertEquals(ParseResult.toResult("abd"), g.parser().parse("abd"));
        assertEquals(ParseResult.toResult("abe"), g.parser().parse("abe"));
        assertEquals(ParseResult.toResult("acd"), g.parser().parse("acd"));
        assertEquals(ParseResult.toResult("ace"), g.parser().parse("ace"));

        assertEquals("'a' ('b'/'c') ('d'/'e')", new GrammarGrammar().inverse()
                .asString().parser().parse(g));

    }
    
    
}
