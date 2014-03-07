/*
 * 
 */
package com.epijava.grammar;

import static org.junit.Assert.*;

import java.util.*;

import com.epijava.grammar.packrat.*;

/**
 * 
 *
 */
public class GrammarAssert {
    public static void assertMatch(Grammar grammar, List<?> input, Object expected) {
        assertEquals(expected, grammar.parser().parse(input));
    }

    public static void assertNoMatch(Grammar grammar, List<?> input, int depth, int pos, Grammar wanted, Object got) {
        try {
            grammar.parser().parse(input);
            fail();
        } catch (GrammarParseException ex) {
            ParseFailure err = ex.getError();
            assertEquals(depth, err.getSubparseDepth());
            assertEquals(pos, err.getPos());
            assertEquals(wanted, err.getExpected());
            assertEquals(got, err.getGot());
        }
    }
    

    public static void assertNoMatch(Grammar grammar, String input, int pos, Grammar wanted, Object got) {
        try {
            grammar.parser().parse(input);
            fail();
        } catch (GrammarParseException ex) {
            ParseFailure err = ex.getError();
            assertEquals(0, err.getSubparseDepth());
            assertEquals(pos, err.getPos());
            assertEquals(wanted, err.getExpected());
            assertEquals(got, err.getGot());
        }
    }

    public static void assertMatchWholeInputStream(Grammar grammar, String input,
            Object expected) {

        // normal
        Object temp = grammar.parser().parse(input);
        assertEquals(expected, temp);

        // reverse the grammar
        Grammar rGrammar = grammar.inverse();

        Object rExpected = ObjectStream.make(input).toSemanticValue();

        // XXX cast to list here is irritating.
        assertEquals(rExpected, rGrammar.parser().parse((List<?>)temp));

    }

    public static void assertMatch(Grammar grammar, String input, Object expected) {
        Object ans = grammar.parser().parse(input);
        assertEquals(expected, ans);
    }

}
