package com.epijava.grammar.packrat;

import java.util.*;

import com.epijava.grammar.*;

public class Head {

    public final Grammar rule;
    public Set<Grammar> involvedSet = new HashSet<Grammar>();
    public Set<Grammar> evalSet = new HashSet<Grammar>();
    
    public Head(Grammar _rule) { rule = _rule; }

}
