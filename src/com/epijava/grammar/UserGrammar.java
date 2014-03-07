package com.epijava.grammar;



/**
 * A grammar that is intended to be subclassed by user code.
 * 
 *
 */
public class UserGrammar extends Grammar {


    /**
     * The main entry point for a user-defined grammar.
     */
    public Grammar main() {
        throw new UnsupportedOperationException("User Grammar "
                + getClass().getName()
                + " does not define a main() entry point");
    }
    
    public int hashCode() { return System.identityHashCode(this); }
    
    public boolean equals(Object that) { return this == that; }

    // ----------------------------------------------------------------------
    // Implementation of the abstract grammar API
    
    public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

    @Override
    public Grammar inverse(final InverseScope scope) {
        // what do we do by default here?
        final Grammar main = main();
        if (main == this)
            throw new AssertionError("XXX "+this); // XXX
        return main.inverse(scope);
    }

    @Override
    protected Object generate(final GenerateState b) {
        final Grammar main = main();
        if (main == this)
            throw new AssertionError("XXX "+this); // XXX
        return main.generate(b);
    }
    
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this));
    }
}
