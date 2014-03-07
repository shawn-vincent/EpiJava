/*
 * 
 */
package com.epijava.grammar;

import org.junit.*;

/**
 * 
 *
 */
public class GeneratorTest extends UserGrammar {

    @Test
    public void testSimpleGeneration() {
        printSome(str("Foo").or(str("Bar")));
                
    }

    private void printSome(Grammar g) {
        System.out.println(g);
        for (int i=0; i<5; i++) {
            System.out.println(g.generator().setOrGenerator(new OrGenerator.Random()).generate());
        }
    }
    
}
