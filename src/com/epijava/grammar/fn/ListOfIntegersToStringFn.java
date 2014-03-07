/*
 * 
 */
package com.epijava.grammar.fn;

import java.util.*;

import com.epijava.grammar.*;
import com.epijava.util.*;

/**
 * XXX this class is crap and need to be massively reworked (for efficiency and
 * cleanliness!)
 * 
 */
public class ListOfIntegersToStringFn extends GrammarFn<List<CodePoint>,String> {

    @Override
    public String invoke(List<CodePoint> in, Map<String,Object> scope) {
        StringBuilder out = new StringBuilder();
        for (CodePoint cp : in)
            // XXX UNICODE!?
            out.append((char)cp.intValue());
        return out.toString();
    }

    @Override
    public List<CodePoint> invokeReverse(String in, Map<String,Object> scope) {
        return (List<CodePoint>)ObjectStream.make(in).toSemanticValue();
    }

    
    public Grammar getSourceGrammar(Grammar targetGrammar)
    { return Grammar.obj(Integer.class).star(); }
    
    public Grammar getTargetGrammar(Grammar sourceGrammar)
    { return Grammar.obj(String.class); }
}
