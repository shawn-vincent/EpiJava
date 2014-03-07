/*
 * 
 */
package com.epijava.grammar.packrat;

import java.util.*;

import com.epijava.grammar.*;
import com.epijava.grammar.Grammar.*;
import com.epijava.util.*;

/**
 * A 'parse' - that is, a current session with the parser.
 * 
 * Internal class, not seen outside the internal guts of grammars and parsers.
 *
 */
public class ParserState<T> implements ParseCheckpoint, Cloneable {
    
    /**
     * parent of this subparse
     */
    private final ParserState<?> parent;
    
    private final String name;
    
    /**
     * The input token stream.
     */
    private final ObjectStream<T> in;
    
    /**
     * The current position in the search results
     */
    private int inPos = 0;

    private final Stack<RuleGrammar> enclosingRules;

    private final Stack<LR> lrStack = new Stack<LR>();;

    private final Map<MemoKey,MemoEntry> memos = new HashMap<MemoKey,MemoEntry>();

    private final Map<Integer,Head> heads = new HashMap<Integer,Head>();
  
    private final LocusBuilder locusBuilder;
    
    public ParserState(final String _name, final ObjectStream<T> _in) {
        this (null, _name, _in);
    }
    
    private ParserState(final ParserState<?> _parent, String _name, final ObjectStream<T> _in) {
        parent = _parent;
        name = _name;
        in = _in;
        if (parent == null)
            enclosingRules = new Stack<RuleGrammar>();
        else
            enclosingRules = parent.enclosingRules;
        
        locusBuilder = new LocusBuilder.CharStreamLocusBuilder(in, "<input>...");
    }
    
    public ParserState<?> getParent() { return parent; }
    
    public String getName() { return name; }

    public int getPos() {
        return inPos;
    }
    
    public void setPos(int v) {
        // XXX very creepy - rather not allow this...
        inPos = v;
    }
    
    public Object peek() {
        if (atEof())
            throw new AssertionError("Tried to peek() at EOF");
        return in.get(inPos);
    }
    
    public Object next() {
        if (atEof())
            throw new AssertionError("Tried to next() at EOF");
        return in.get(inPos++);
    }
    
    public boolean atEof() {
        return inPos >= in.size();
    }
    
    public <U> ParserState<U> subparse(String name, ObjectStream<U> in) {
        ParserState<U> r = new ParserState<U>(this, name, in);

        return r;
    }

    public void commitSubparse(ParserState<Object> propertyParse) {
    }

    public int getSubparseDepth() {
        if (parent == null)
            return 0;
        else
            return parent.getSubparseDepth() + 1;
    }

    public ParseCheckpoint checkpoint() {
        return clone();
    }
    
    public void rollback(ParseCheckpoint checkpoint) {
        copyFrom((ParserState<?>)checkpoint);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    protected ParserState<T> clone() {
        ParserState<T> r;
        try {
            r = (ParserState<T>)super.clone();
        } catch (final CloneNotSupportedException e) {
            throw (AssertionError)new AssertionError().initCause(e);
        }
        return r;
    }

    private void copyFrom(final ParserState<?> that) {
        if (this.in != that.in) throw new AssertionError();
        this.inPos = that.inPos;
    }
    
    public ParserState<T> beginRule(RuleGrammar rule) {
        enclosingRules.push(rule);
        return this;
    }

    public void endRule(RuleGrammar rule, ParserState<?> ruleParse) {
        if (ruleParse != this)
            throw new AssertionError("Bad ruleParse passed to endRule()");
        
        RuleGrammar r = enclosingRules.pop();
        if (r != rule)
            throw new AssertionError(
                    "beginRule() and endRule() don't nest properly");
    }

    public RuleGrammar getEnclosingRule(String ruleName) {
        // XXX way too slow.
        int size = enclosingRules.size();
        for (int i=size-1; i>=0; i--) {
            RuleGrammar rule = enclosingRules.get(i);
            if (rule.getName().equals(ruleName))
                return rule;
        }
        throw new AssertionError("No such enclosing rule definition for recurse: "+ruleName);
    }

    public void addMemo(MemoEntry m) {
        memos.put(new MemoKey(m.getGrammar(), m.getPos()), m);
    }

    public MemoEntry getMemo(Grammar grammar, int pos) {
        return memos.get(new MemoKey(grammar, pos));
    }
    
    private static class MemoKey {
        private final Grammar grammar;
        private final int pos;
        public MemoKey(Grammar grammar, int pos) {
            super();
            this.grammar = grammar;
            this.pos = pos;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((grammar == null) ? 0 : grammar.hashCode());
            result = prime * result + pos;
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
            
            final MemoKey other = (MemoKey) obj;
            if (grammar == null) {
                if (other.grammar != null)
                    return false;
            } else if (!grammar.equals(other.grammar))
                return false;
            if (pos != other.pos)
                return false;
            return true;
        } 
    }

    public LR beginPossibleLeftRecursion(Grammar rule) { 
        LR lr = new LR(ParseResult.Fail, rule, null);
        lrStack.push(lr);
        return lr;
    }

    public void endPossibleLeftRecursion(LR lr) {
        if (lr != lrStack.pop())
            throw new AssertionError();
    }
    
    /**
     * Called when we encounter an actual left recursive invocation.
     **/
    public void encounteredLeftRecursion (Grammar rule, LR lr) {
        // create the head if it doesn't already exist.
        if (lr.getHead() == null)
            lr.setHead(new Head(rule));

        // search the LR stack (from top to bottom) and find all rules 
        // before the LR head.
        for (int i=lrStack.size()-1; i>=0; i--) {
            LR s = lrStack.get(i);
            if (s.getHead() == lr.getHead()) break;
            s.setHead(lr.getHead());
            lr.getHead().involvedSet.add(s.getRule());
        }
    }

    public Head getHead(int pos) {
        return heads.get(pos);
    }

    public void setHead(int pos, Head h) {
        heads.put(pos, h);
    }
    
    public void clearHead(int pos) {
        heads.remove(pos);
    }

    public Locus getCurrentLocus() {
        Object curr;
        if (atEof())
            curr = null;
        else
            curr = in.get(inPos);
        return locusBuilder.buildLocus(curr, inPos);
    }

    public Object peekOrEof() {
        if (atEof())
            return ParseFailure.EOF;
        else
            return peek();
    }
    
    public String toString() {
        return "ParserState(inPos:"+inPos+")";
    }
}
