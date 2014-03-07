/*
 * 
 */
package com.epijava.grammar.packrat;

import java.util.*;

import com.epijava.grammar.*;
import com.epijava.grammar.Grammar.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class ParseResult {
    
    private static final Object FailAns = new Object() {
        public String toString() {
            return "** FAIL **";
        }
    };
    
    public static final ParseResult Fail = new ParseResult(FailAns);

    public static final ParseResult Empty = new ParseResult(Collections.EMPTY_LIST);
    
    private final Object ans;
    
    private final Map<String,Object> scope;
    
    private final ParseFailure error;

    public ParseResult(Object _ans) 
    { this(_ans, new HashMap<String,Object>(), null); }
    
    public ParseResult(Object _ans, ParseFailure _error) 
    { this(_ans, new HashMap<String,Object>(), _error); }

    public ParseResult(ParseResult pr) 
    { this(pr.ans, new HashMap<String,Object>(pr.scope), pr.error); }
    
    private ParseResult(Object _ans, Map<String,Object> _scope, ParseFailure _error) {
        ans = _ans; scope = _scope; error = _error;
    }
    
    public boolean isFail() { return ans == FailAns; }

    public ParseResult bindLabel(String name, Object value) {
        // XXX creepy mute scope
        ParseResult r = new ParseResult(this);
        r.scope.put(name, value);
        return r;
    }

    public ParseResult addScope(ParseResult pr) {
        return new ParseResult(ans, union(scope, pr.scope), pr.error);
        
    }

    public ParseResult setAns(Object _ans) {
        return new ParseResult(_ans, scope, error);
    }


    public ParseResult seq(ParseResult r) {
        return new ParseResult(GrammarUtil.concat(ans, r.ans), union(scope, r.scope), ParseFailure.join(error, r.error));
    }
    
    public ParseFailure getError() {
        return error;
    }
    
    public ParseResult joinError(ParseFailure _error) {
        return new ParseResult(ans, scope, ParseFailure.join(error, _error));
    }

    public ParseResult joinError(ParseResult r) {
        return joinError(r.error);
    }
    

    public ParseResult annotateError(RuleGrammar rule, int startPos) {
        if (error != null && error.getPos() == startPos)
            return new ParseResult(ans, scope, error.annotate(rule, startPos));
        else
            return this;
    }
    
    public static <K, V> Map<K, V> union(Map<K, V> a, Map<K, V> b) {
        Map<K, V> r = new HashMap<K, V>(a);
        for (Map.Entry<K, V> entry : b.entrySet()) {
            r.put(entry.getKey(), entry.getValue());
        }
        return r;
    }

    public Map<String,Object> getScope() { return scope; }

    public Object getAns() {
        return ans;
    }

    public static List<CodePoint> toResult(String v) {
        return ObjectStream.make(v).toSemanticValue();
    }
    
    public String toString() {
        return "ParseResult("+ans+" / "+error+", "+scope+")";
    }

}
