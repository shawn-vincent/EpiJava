/*
 * 
 */
package com.epijava.grammar.packrat;

import com.epijava.grammar.*;

/**
 * 
 *
 */
public class MemoEntry {
    
    private final Grammar grammar;
    
    // we'd like these to be final.
    private int pos;
    private ParseResult ans;

    public MemoEntry(Grammar _grammar, int _pos, ParseResult _ans) {
        grammar = _grammar;
        pos = _pos;
        ans = _ans;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public ParseResult getAns() {
        return ans;
    }

    public void setAns(ParseResult ans) {
        this.ans = ans;
    }

    public Grammar getGrammar() {
        return grammar;
    }
    
    public String toString() {
        return "Memo("+grammar+"["+pos+"] = "+ans+")";
    }

}
