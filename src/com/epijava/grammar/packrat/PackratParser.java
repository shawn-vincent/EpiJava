/*
 * 
 */
package com.epijava.grammar.packrat;

import java.util.*;

import com.epijava.grammar.*;
import com.epijava.grammar.Grammar.*;
import com.epijava.grammar.fn.*;
import com.epijava.util.*;

/**
 * 
 *
 */
public class PackratParser extends Parser {
    
    private final PackratVisitor visitor;

    public PackratParser(Grammar _grammar) {
        super(_grammar);
        visitor = makeVisitor();
    }
    
    protected PackratVisitor makeVisitor() { return new PackratVisitor(this); }

    @Override
    public <T> Object parse(ObjectStream<T> in) throws GrammarParseException {
        ParserState<T> parse = new ParserState<T>("input", in);
        ParseResult result = parseNonRecursive(grammar, parse);
        if (result.isFail())
            throw new GrammarParseException("Could not parse "+in, result.getError());
        return result.getAns();
    }
    
    protected ParseResult parseNonRecursive(Grammar g, ParserState<?> in) {
        return g.accept(visitor, in);
    }
    
    protected final ParseResult parseRecursive (Grammar g, ParserState<?> p) {
        
        int pos = p.getPos();
        
        MemoEntry m = recall(g, p, pos);

        // no such memo entry.
        if (m == null) {

            // create a new LR and push it onto the rule invocation stack
            LR lr = p.beginPossibleLeftRecursion(g);

            // Memoize "lr".
            // this means that subsequent (recursive) calls to this rule
            // will see this memo entry.
            m = new MemoEntry(g, pos, new ParseResult(lr));
            p.addMemo(m);

            // evaluate this rule (rule-specific stuff).
            // generates output into 'p'.
            ParseResult ans = parseNonRecursive(g, p);

            // Pop lr off the rule invocation stack
            p.endPossibleLeftRecursion(lr);
            
            m.setPos(p.getPos());

            // update the memo entry.
            if (lr.getHead() != null) {
                // if we actually encountered a left recursive invocation,
                // grow the answer using 'p.ans' as the seed parse.
                lr.setSeed(ans);
                return resolveLeftRecursion(g, p, pos, m);
            } else {
                // otherwise, just update the memo, return the value.
                m.setAns(ans);
                return ans;
            }

        // Memo entry exists
        } else {
            p.setPos(m.getPos());
            
            if (m.getAns().getAns() instanceof LR) {
                LR lr = (LR)m.getAns().getAns();
                // the memo entry indicates this is a recursive call.
                // i.e. - we've actually encountered a left recursion.

                // setup the LR so that when we unwind the stack, we can
                // grow the seed.
                p.encounteredLeftRecursion(g, lr);

                // set our answer to our seed.
                return lr.getSeed();
            } else {
                // the memo entry is a normal memo entry: just use it.
                return m.getAns();
            }
        }
    }

    /**
     * Fetch the memo entry for the given position.
     **/
    private MemoEntry recall(Grammar g, ParserState<?> p, int pos) {
        MemoEntry m = p.getMemo(g, pos);
        Head h = p.getHead(pos);

        // if not growing a seed parse, just return what is stored in
        // the memo table
        if (h == null)
            return m;

        // do not evaluate any rule that is not involved in this left recursion
        if (m == null && g != h.rule && !h.involvedSet.contains(this))
            return new MemoEntry(g, pos, ParseResult.Fail);

        // allow involved rules to be evaluated, but only once,
        // during a seed growing iteration
        if (h.evalSet.contains(g)) {
            h.evalSet.remove(g);
            
            ParseResult pr = parseNonRecursive(g, p);
            
            m.setAns(pr);
            m.setPos(p.getPos());
        }

        return m;
    }



    /**
     * Called when we want the true answer to a left recursive invocation.
     **/
    private ParseResult resolveLeftRecursion (Grammar g, ParserState<?> p, int pos, MemoEntry m) {
        LR lr = (LR)m.getAns().getAns();
        Head h = lr.getHead();
        if (h.rule != g) {
            // if we're not the head rule, we don't try to grow anything.
            return lr.getSeed();
        } else {
            // otherwise, start with the seed...
            m.setAns(lr.getSeed());
            if (m.getAns().isFail())
                // if the seed is fail, return that.
                return m.getAns();
            else
                // otherwise, grow the seed.
                return growLeftRecursion(g, p, pos, m, h);
        }
    }

 
    /**
     * Grow the seed
     **/
    private ParseResult growLeftRecursion (Grammar g, ParserState<?> p, int pos, MemoEntry m, Head h) {
        // store the current head into the heads map
        p.setHead(pos, h); // line A

        // loop until we're done growing the seed
        while (true) {
            p.setPos(pos);
            
            // remember the evaluation set (evaluated in recall())
            h.evalSet = new HashSet<Grammar>(h.involvedSet); // line B

            // recurse
            ParseResult ans = parseNonRecursive(g, p);

            // if we failed (or didn't get as far as the seed), we're done.
            if (ans.isFail() || p.getPos() <= m.getPos())
                break;

            // that's our answer otherwise, and grow again (loop)
            m.setAns(ans);
            m.setPos(p.getPos());
        }

        // no longer growing: clear the current head.
        p.clearHead(pos); // ... line C

        // that's our answer now.
        p.setPos(m.getPos());
        return m.getAns();
    }


    protected static class PackratVisitor extends GrammarVisitor<ParserState<?>, ParseResult> {
        
        private final PackratParser parser;
        
        public PackratVisitor(PackratParser _parser) { parser = _parser; }

        @Override
        public ParseResult visit(EmptyGrammar g, ParserState<?> p) {
            return ParseResult.Empty;
        }
        
        @Override
        public ParseResult visit(EofGrammar g, ParserState<?> p) {
            if (p.atEof())
                return ParseResult.Empty;
            else
                return ParseResult.Fail
                    .joinError(ParseFailure.expected(p, g));
        }
        

        @Override
        public ParseResult visit(ConstantGrammar g, ParserState<?> p) {
            if (p.atEof())
                return ParseResult.Fail
                    .joinError(ParseFailure.expected(p, g));

            final Object next = p.peek();
            if (CompareUtil.equals(next, g.getValue()))
                return new ParseResult(p.next());

            return ParseResult.Fail
                .joinError(ParseFailure.expected(p, g));
        }
        
        @Override
        public ParseResult visit(LabelGrammar g, ParserState<?> p) {
            ParseResult r = parser.parseNonRecursive(g.getBody(), p);
            if (r.isFail()) return r;
            return r.bindLabel(g.getName(), r.getAns());
        }
        

        @Override
        public ParseResult visit(RefGrammar g, ParserState<?> p) {
            throw new UnsupportedOperationException(
            "REF is not allowed in a parse expression.  Use LABEL instead.");
        }

        @Override
        public ParseResult visit(ObjectGrammar<?> g, ParserState<?> p) {
            if (p.atEof()) {
                return ParseResult.Fail
                .joinError(ParseFailure.expected(p, g));
            }

            final Object next = p.peek();
            if (!g.getType().isInstance(next))
                return ParseResult.Fail
                .joinError(ParseFailure.expected(p, g));

            ParseResult r = ParseResult.Empty;
            for (final Property property : g.getProperties()) {  
                ParseResult pr = parseProperty(property, next, p);
                if (pr.isFail())
                    return pr;

                r = r.addScope(pr);
            }

            r = r.setAns(p.next());

            return r;
        }
        
        ParseResult parseProperty(Property prop, Object o, ParserState<?> p) {
            final ParserState<Object> subparse = p.subparse(prop.getName(), ObjectStream
                    .make(prop.getGetter().invoke(o)));
            try {
                return parser.parseNonRecursive(prop.getPattern(), subparse);
            } finally {
                p.commitSubparse(subparse);
            }
        }

        @Override
        public ParseResult visit(SeqGrammar g, ParserState<?> p) {
            ParseResult l = parser.parseNonRecursive(g.getLhs(), p);
            if (l.isFail())
                return l;

            ParseResult r = parser.parseNonRecursive(g.getRhs(), p);
            if (r.isFail())
                return r.joinError(l);

            return l.seq(r);
        }
        
        @Override
        public ParseResult visit(OrGrammar g, ParserState<?> p) {

            final ParseCheckpoint checkpoint = p.checkpoint();

            ParseResult l = parser.parseRecursive(g.getLhs(), p);
            if (!l.isFail()) return l;

            p.rollback(checkpoint); // undo

            ParseResult r = parser.parseRecursive(g.getRhs(), p);
            if (!r.isFail()) return r.joinError(l);

            p.rollback(checkpoint); // undo

            // both are failures.
            return l.joinError(r);
        }

        @Override
        public ParseResult visit(NotGrammar g, ParserState<?> p) {
            ParseCheckpoint checkpoint = p.checkpoint();

            ParseResult r = parser.parseNonRecursive(g, p);
            if (!r.isFail())
                return ParseResult.Fail
                .joinError(ParseFailure.expected(p, g));
            
            p.rollback(checkpoint);
            
            return ParseResult.Empty;
        }
        
        @Override
        public ParseResult visit(AndGrammar g, ParserState<?> p) {
            ParseCheckpoint beginning = p.checkpoint();
            
            // parse LHS
            ParseResult l = parser.parseRecursive(g.getLhs(), p);
            if (l.isFail())
                return l;
            
            ParseCheckpoint end = p.checkpoint();
            
            // RHS has to match also, but the result is ignored.
            p.rollback(beginning);
            ParseResult r = parser.parseRecursive(g.getRhs(), p);
            if (r.isFail())
                return r.joinError(l);
            
            // go back to the end of the LHS parse (RHS parse is ignored except
            // if it fails)
            p.rollback(end);
            return l;
        }

        @Override
        public ParseResult visit(RecurseGrammar g, ParserState<?> p) {
            return parser.parseRecursive(p.getEnclosingRule(g.getRuleName()), p);
        }

        @SuppressWarnings("unchecked")
        @Override
        public ParseResult visit(WrapGrammar<?,?> g, ParserState<?> p) {
            ParseResult r = parser.parseNonRecursive(g.getInputGrammar(), p);
            if (r.isFail())
                return r;
            
            // wrap.parse preserves underlying variable definitions
            return r.setAns(((GrammarFn<Object,Object>)g.getFn())
                    .invoke(r.getAns(), r.getScope()));
        }
        
        @Override
        public ParseResult visit(RuleGrammar g, ParserState<?> p) {
            int startPos = p.getPos();
            ParserState<?> ruleParse = p.beginRule(g);
            
            try {
                ParseResult r = parser.parseNonRecursive(g.getBody(), p);
                
                if (r.isFail())
                    return r.annotateError(g, startPos);
                
                return new ParseResult(r.getAns()).annotateError(g, startPos);
            } finally {
                p.endRule(g, ruleParse);
            }
        }
        
        @Override
        public ParseResult visit(CanonicalGrammar g, ParserState<?> p) {
            return parser.parseNonRecursive(g.getReal(), p);
        }

        @Override
        public ParseResult visit(UserGrammar g, ParserState<?> p) {
            final Grammar main = g.main();
            if (main == g)
                throw new AssertionError("XXX "+g); // XXX
            return parser.parseNonRecursive(main, p);
        }

        
        
    }
}
