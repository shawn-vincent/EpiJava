/*
 * 
 */
package com.epijava.grammar;

/**
 * 
 * 
 */
public abstract class OrGenerator {



    public abstract Object generate(Grammar rhs, Grammar lhs,
            GenerateState state);

    /**
     * 
     * 
     */
    public static class Disallowed extends OrGenerator {

        public Object generate(Grammar rhs, Grammar lhs, GenerateState state) {
            throw new AmbiguousGrammarException(
                    "OR (G1 / G2) cannot be used in this generator: don't know which of "
                            + rhs + " and " + lhs + " to build!");
        }

    }
    
    /**
     * 
     *
     */
    public static class Random extends OrGenerator {

        @Override
        public Object generate(Grammar rhs, Grammar lhs, GenerateState state) {
            if (new java.util.Random().nextBoolean())
                return rhs.generate(state);
            else
                return lhs.generate(state);
        }

    }
}
