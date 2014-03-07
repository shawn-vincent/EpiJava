/*
 * 
 */
package com.epijava.grammar;

import java.util.*;

import com.epijava.grammar.fn.*;
import com.epijava.grammar.packrat.*;
import com.epijava.lang.reflect.*;
import com.epijava.util.*;

/**
 * A combinator-based grammar construction API.
 * 
 * <p>
 * Constructed grammars can be used to parse and print data structures.
 * 
 * <p>
 * Actually, these grammars provide two-way transformation (matching and
 * building) of general forest data structures. Parsing and printing of ASTs is
 * a special case (a stream of characters is a forest of 1-deep trees)
 * 
 * <p>
 * Trees in this data structure have named branches, rather than just a list.
 * This makes them equivalent to Java Objects.
 * 
 * <p>
 * These grammars may be used for parsing streams of objects and/or generating
 * streams of objects.
 * 
 */
public abstract class Grammar {
 
    /**
     * Get a parser for this grammar.
     */
    public Parser parser() {
        return new PackratParser(this);
    }
    
    public Generator generator() {
        return generator(new HashMap<String,Object>());
    }
    

    public Generator generator(Map<String, Object> scope) {
        return new Generator(this, scope);
    }

    /**
     * Get a pretty printer for this grammar.
     */
    public Printer printer() {
        throw new UnsupportedOperationException();
    }

    /**
     * Transform this grammar so that it recognizes its output, and builds its
     * input.
     * 
     */
    public final Grammar inverse() {
        return inverse(new InverseScope());
    }
    
    public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }
    
    /**
     * Build a data structure according to this grammar.
     * 
     * <p>This method is called on grammars on the RHS of a WRAP expresion.
     */
    protected abstract Object generate(GenerateState b);

    /**
     * Invert this grammar, creating a new grammar.
     */
    public abstract Grammar inverse(InverseScope scope);
    
    /**
     * Print a nice human-readable expression representing this grammar.
     */
    @Override
    public abstract String toString();
    
    // ------------------------------------------------------------------------
    // Terminal productions

    /**
     * Generate a grammar that recognizes the empty language.
     * 
     * <p>The semantic value returned is the empty list.
     * 
     * <p>In a build expression, generates an empty list.
     * 
     * <p>Sometimes printed as ()
     */
    public static Grammar empty() {
        return new EmptyGrammar();
    }
    
    public static Grammar eof() {
        return new EofGrammar();
    }

    /**
     * Generates a grammar that recognizes a constant value.
     * 
     * <p>The semantic value returned is the constant value.
     * 
     * <p>In a build expression, generates the constant value.
     */
    public static Grammar constant(final Object constant) {
        return new ConstantGrammar(constant);
    }

    /**
     * Generates a grammar that recognizes a null object reference.
     * 
     * <p>
     * The semantic value returned is the value 'null'.
     * 
     * <p>
     * In a build expression, generates a 'null' value.
     * 
     * <p>
     * Note: the name "nil" was used instead of "null" because "null" is a Java
     * keyword and can't be used as a method name. "nil" is the Smalltalk
     * equivalent to Java's null, and is one character shorter! :-)
     */
    public static Grammar nil() {
        return constant(null);
    }
    
    /**
     * Matches a character, returns a character.
     * 
     * <p>
     * The semantic value returned is the given character.
     * 
     * <p>
     * In a build expression, generates the character.
     * 
     * <p>
     * The character passed in is a Unicode code point (and so can represent any
     * Unicode character, not just the ones encodable in 16 bits).
     */
    public static Grammar ch(final int c) {
        return new ConstantGrammar(CodePoint.valueOf(c));
    }

    /**
     * Matches a character in the range, returns a character.
     * 
     * <p>
     * The semantic value returned is the specific character matched.
     * 
     * <p>
     * NOT LEGAL in a build expression: represents an OR expression, and is
     * therefore ambiguous.
     * 
     * <p>
     * The character passed in is a Unicode code point (and so can represent any
     * Unicode character, not just the ones encodable in 16 bits).
     */
    public static Grammar ch(final char start, final char end) {
        Grammar r = ch(start);
        for (int i = start + 1; i <= end; i++)
            r = r.or(ch(i));
        return r;
    }

    /**
     * Matches each of the characters in the given String, returns a list of
     * characters.
     * 
     * <p>
     * The semantic value returned is a List of the characters matched, as
     * Integer Unicode code points (not a String object)
     * 
     * <p>
     * In a build expression, generates the List of characters, as Integer
     * Unicode code points.
     * 
     * <p>
     * The String passed in is interpreted as a list of Unicode code points (and
     * so can represent any Unicode character, not just the ones encodable in 16
     * bits).
     */
    public static Grammar str(final CharSequence s) {
        Grammar r = empty();
        final int length = Character.codePointCount(s, 0, s.length());
        for (int i = 0; i < length; i++)
            r = r.seq(ch(Character.codePointAt(s, i)));
        return r;
    }

    /**
     * Returns a grammar rule named "optional whitespace" that matches zero or
     * more space characters, as defined by {@link #spaceChar()}.
     * 
     * <p>
     * The canonical form of this grammar is the empty string.
     */
    public static Grammar optS() {
        return spaceChar().star().canonical(empty()).rule("optional whitespace");
    }

    /**
     * Returns a grammar rule named "whitespace" that matches one or more space
     * characters, as defined by {@link #spaceChar()}
     * 
     * <p>
     * The canonical form of the returned grammar is a string containing a
     * single space character (' ')
     */
    public static Grammar S() {
        return spaceChar().plus().canonical(ch(' ')).rule("whitespace");
    }

    /**
     * Matches any of the traditional ASCII space characters: space, tab,
     * carriage return or newline
     */
    private static Grammar spaceChar() {
        return union(ch(' '), ch('\t'), ch('\r'), ch('\n'));
    }
    
    /**
     * Grammar modifier: evaluates the base grammar, and then adds a labeled
     * value to the current scope with the semantic value of the grammar's
     * result.
     * 
     * <p>
     * If another label with the same name is encountered again during a parse,
     * the grammar is evaluated as normal, but the parse will fail if the
     * semantic values of the two labeled grammars are not equal.
     * 
     * <p>
     * Illegal to use in a build expression.
     */
    public Grammar label(final String propertyName) {
        return new LabelGrammar(this, propertyName);
    }

    /**
     * Fetches a previously labeled semantic value. Usable only in a build
     * expression.
     * 
     * <p>
     * In a build expression, generates the semantic value generated by the
     * labeled expression previously evaluated in the parse.
     * 
     * <p>
     * If no label of the given name has been evaluated, throws an exception.
     * 
     * <p>
     * Illegal to use in a parse expression.
     */    
    public static Grammar ref(final String propertyName) {
        return new RefGrammar(propertyName);
    }

    /**
     * Matches an object of the given type on the input stream, with sub-matches
     * for each of the named properties.
     * 
     * <p>
     * In a parse expression, expects an object of the given type on the input
     * stream. Each sub property must match with the given parse expression on
     * the property value of the matched object. Otherwise, the parse fails.
     * 
     * <p>
     * The semantic value of the parse expression is the object that is matched.
     * 
     * <p>
     * In a build expression, constructs an object of the given type, setting
     * the given properties with the result of executing the build expressions
     * for each property.
     */
    public static <T> Grammar obj(final Class<T> type, final Property... properties) {
        return new ObjectGrammar<T>(type, properties);
    }

    /**
     * Equivalent to obj(Object.class)
     * 
     * <p>
     * This means that in a parse expression, this grammar will expect any
     * object (other than NULL), with any properties (since there are no
     * property constraints). The semantic value will be the matched object.
     * 
     * <p>
     * In a build expression, this will generate a new instance of
     * java.lang.Object
     * 
     * Note: does NOT match NULL.
     */
    public static Grammar obj() {
        return obj(Object.class);
    }
    
    /**
     * <p>
     * Matches any object or NULL.
     * 
     * <p>
     * Similar to '.' in regular expressions, extended to tree grammars over
     * Java objects.
     * 
     * <p>
     * Illegal in a build expression, as this is equivalent to obj() OR nil().
     */
    public static Grammar any() {
        return obj().or(nil());
    }

    /**
     * <p>Defines a property for an obj() grammar
     */
    public static Property prop(final String name, final Grammar pattern) {
        return new Property(name, -1, pattern);
    }

    public static Property prop(final int constructorParameter, final Grammar pattern) {
        return new Property(null, constructorParameter, pattern);
    }

    public static Property prop(final String name, final int constructorParameter, final Grammar pattern) {
        return new Property(name, constructorParameter, pattern);
    }    
    
    
    // ------------------------------------------------------------------------
    // Combiners

    /**
     * <p>Sequence operator
     * 
     * <p>
     * Matches this grammar, and then the specified one.
     * 
     * <p>
     * Returns a list of this grammar's contents, concatenated with that
     * grammar's contents.
     * 
     * <p>
     * In a build expression, concatenates the result of evaluating both
     * sequenced build expressions.
     */
    public Grammar seq(final Grammar next) {
        return new SeqGrammar(this, next);
    }
    
    /**
     * Convenience method to sequence zero or more grammars into a single sequence.
     */
    public static Grammar sequence(final Grammar... grammars) {
        Grammar r = empty();
        for (Grammar g : grammars)
            r = r.seq(g);
        return r;
    }

    /**
     * <p>
     * Nonexclusive, ordered OR: match either LHS or RHS.
     * 
     * <p>
     * Matches the FIRST successfully parsed grammar (LHS is checked first, and
     * then RHS)
     * 
     * <p>
     * This is the basis for backtracking in the grammar combinator system. If
     * the first grammar doesn't match, the parser will back up and try the
     * other one.
     * 
     * <p>
     * The semantic value is the semantic value of the successfully parsed
     * grammar.
     * 
     * <p>
     * In a build expression, relies on a {@link OrGenerator} to determine which
     * choice to choose. The default OrGenerator is {@link OrGenerator.Disallowed}
     * 
     * <p>
     * TODO: Maybe someday implement Exclusive OR
     */
    public Grammar or(final Grammar alt) {
        return new OrGrammar(this, alt);
    }
    
    /**
     * Convenience method to OR one or more grammars into a union.
     */
    public static Grammar union(final Grammar... grammars) {

        Grammar r = null;
        
        for (Grammar g : grammars)
            if (r == null)
                r = g;
            else
                r = r.or(g);
        
        if (r == null)
            throw new IllegalArgumentException(
                    "Empty list of grammars cannot be unioned");
        
        return r;
    }
    
    /**
     * AND: match both LHS and RHS.
     * 
     * <p>
     * Matches only if the LHS and the RHS of the AND expression match. The
     * parse position is left at the end of the LHS match, regardless of what
     * the RHS does.
     * 
     * <p>
     * Returns the semantic value of the LHS.
     * 
     * <p>
     * A way of thinking about this is: the LHS is the true parse expression,
     * and any expression on the RHS is just a guard or check: an additional
     * condition to place on the parsed value.
     * 
     * <p>
     * Generates as though it were the LHS. XXX This is an issue: it is not
     * guaranteed that X.and(Y).generator().generate() will generate something
     * that can then be parsed by X.and(Y).parser().parse().
     * 
     * <p>
     * Note for PEG users: and is not the same as the PEG & operator. That
     * operator, in PEG terminology, corresponds to the
     * {@link #followedBy(Grammar)} operator.
     */
    public Grammar and(Grammar rhs) {
        return new AndGrammar(this, rhs);
    }
    
    /**
     * Convenience method to AND one or more grammars into an intersection
     */
    public static Grammar intersection(Grammar... grammars) {

        Grammar r = null;
        
        for (Grammar g : grammars)
            if (r == null)
                r = g;
            else
                r = r.and(g);
        
        if (r == null)
            throw new IllegalArgumentException(
                    "Cannot intersect an empty set of grammars");
        
        return r;
    }
    
    /**
     * NOT: match only if a grammar DOESN'T match.
     * 
     * <p>
     * Matches only if the specified grammar doesn't match. The parse position
     * is unchanged.
     * 
     * <p>
     * Generates an empty list. XXX This may be an issue. It is not guaranteed
     * that a grammar with a NOT in it will generate a data structure that can
     * then be successfully parsed.
     * 
     * <p>
     * Note for PEG users: this is not the same as the PEG ! operator.That
     * operator, in PEG terminology, corresponds to the
     * {@link #notFollowedBy(Grammar)} operator.
     */
    public static Grammar not(final Grammar g) {
        return new NotGrammar(g);
    }

    /**
     * Matches (greedily) zero or more matches of this grammar.
     * 
     * Returns a list of the results, concatenated.
     */
    public Grammar star() {
        String ruleName = this.toString() + "*";
        return seq(recurse(ruleName)).or(empty()).rule(ruleName);
    }

    /**
     * Matches (greedily) one or more matches of this grammar.
     * 
     * Returns a list of the results, concatenated.
     */
    public Grammar plus() {
        return this.seq(star());
    }

    public Grammar opt() {
        return this.or(empty());
    }

    
    public Grammar followedBy(final Grammar next) {
        return seq(empty().and(next));
    }
    
    public Grammar notFollowedBy(Grammar next) {
        return seq(not(next));
    }
    
    /**
     * Transforms the semantic value of this grammar (assumed to be a List<Integer>)
     * into a String value.
     */
    public Grammar asString() {
        return wrap(new ListOfIntegersToStringFn());
    }
    
    public <I,O> Grammar wrap(GrammarFn<I,O> fn) {
        return new WrapGrammar<I,O>(this, fn);
    }

    /**
     * Wraps the result of the LHS grammar with the result of evaluating the RHS
     * grammar.
     * 
     * <p>
     * the RHS grammar gets the scope of the LHS grammar, but not the semantic
     * value.
     */
    public Grammar wrap(final Grammar ref) {
        return wrap(new GenerateFn(this, ref));
//        return new WrapGrammar(this, ref);
    }

    
    public RuleGrammar rule(String name) {
        return new RuleGrammar(name, this);
    }
    
    public static Grammar recurse(String ruleName) {
        return new RecurseGrammar(ruleName);
    }
    
    /**
     * Provides a canonical form of this grammar.
     * 
     * <p>
     * A canonical form is what is generated if the grammar is pretty printed or
     * generated.
     * 
     * <p>
     * This is convenient for grammars whose productions match an infinite
     * number of strings, but you want to generate only a finite number for
     * human readability.
     */
    public Grammar canonical(Grammar g) {
        return new CanonicalGrammar(this, g);
    }
    
    /**
     * All Grammar subclasses must appropriately implement hashCode()
     * 
     * <p>
     * Two grammars that are structurally identical must produce the same
     * hashCode().
     */
    @Override
    public abstract int hashCode();
    
    /**
     * All Grammar subclasses must appropriately implement equals()
     * 
     * <p>Two grammars should return true only if they are structurally identical.
     */
    @Override
    public abstract boolean equals(Object that);

    protected boolean equalsOrIsPartOfOr(Grammar v) {
        return equals(v);
    }
    
    // ------------------------------------------------------------------------
    // Implementation classes
 
    /**
     * 
     *
     */
    public final static class EmptyGrammar extends Grammar {

        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(final InverseScope scope) { return this; }

        /**
         * () seq g == g
         */
        @Override
        public Grammar seq(final Grammar g) { return g; }
        
        @Override
        protected Object generate(final GenerateState r) {
            return Collections.EMPTY_LIST;
        }
        
        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass()); }
        
        @Override
        public boolean equals(Object that) { return that instanceof EmptyGrammar; }

        @Override
        public String toString() { return "()"; }
    }
    
    /**
     * 
     */
    public static class EofGrammar extends Grammar {

        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(InverseScope scope) { return this; }   

        @Override
        protected Object generate(GenerateState b) {
            return Collections.EMPTY_LIST;
        }

        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass()); }
        
        @Override
        public boolean equals(Object _that) { return _that instanceof EofGrammar; }

        @Override
        public String toString() { return "EOF"; }
    } 
    /**
     * 
     *
     */
    public final static class ConstantGrammar extends Grammar {
        private final Object value;

        public ConstantGrammar(final Object _constant) {
            value = _constant;
            // value may be null.
        }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        public Object getValue() { return value; }

        @Override
        public Grammar inverse(final InverseScope scope) { return this; }

        @Override
        protected Object generate(GenerateState rhsParse) { return value; }

        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), value); }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof ConstantGrammar)) return false;
            final ConstantGrammar that = (ConstantGrammar) _that;
            if (!CompareUtil.equals(this.value, that.value)) return false;
            return true;
        }   
        
        @Override
        public String toString() {
            if (value instanceof CodePoint) return "'" + value + "'";
            if (value instanceof String) return "\"" + value + "\"";
            return String.valueOf(value);
        }
    }

    /**
     * 
     *
     */
    public final static class LabelGrammar extends Grammar {
        private final Grammar g;
        private final String name;

        public LabelGrammar(final Grammar _g, final String _name) {
            g = _g;
            name = _name;
            if (g == null || name == null)
                throw new NullPointerException();
        }

        public String getName() {
            return name;
        }
        
        public Grammar getBody() { return g; }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(final InverseScope scope) {
            if (scope.labels.containsKey(name))
                throw new AssertionError("Cannot have two labels with the same name: "+name);
            scope.labels.put(name, g);
            return new RefGrammar(name);
        }
        
        @Override
        protected Object generate(final GenerateState b) {
            throw new UnsupportedOperationException(
                    "LABELLED EXPRESSION is not allowed in a build expression.  Use a REF instead.");
        }

        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), g, name); }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof LabelGrammar)) return false;
            final LabelGrammar that = (LabelGrammar) _that;
            if (!CompareUtil.equals(this.g, that.g)) return false;
            if (!CompareUtil.equals(this.name, that.name)) return false;
            return true;
        }
        
        @Override
        public String toString() { return name + "=" + g; }
    }

    /**
     * 
     *
     */
    public final static class RefGrammar extends Grammar {

        private final String name;

        public RefGrammar(final String _name) {
            name = _name;
            if (name == null) throw new NullPointerException();
        }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }
        
        @Override
        public Grammar inverse(final InverseScope scope) {
            final Grammar grammar = scope.labels.get(name);
            if (grammar == null)
                throw new AssertionError("Label not found for ref: '"+name+"'");
            return new LabelGrammar(grammar.inverse(scope), name);
        }
        
        @Override
        protected final Object generate(final GenerateState b) {
            if (!b.hasScopeValue(name))
                throw new AssertionError("Label not found for ref: '"+name+"'");
            return b.getScopeValue(name);
        }
        
        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), name); }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof RefGrammar)) return false;
            final RefGrammar that = (RefGrammar) _that;
            if (!CompareUtil.equals(this.name, that.name)) return false;
            return true;
        }
        
        @Override
        public String toString() { return name; }
    }

    /**
     * 
     */
    public final static class ObjectGrammar<T> extends Grammar {
        private final Class<T> type;
        private final Property[] properties;

        private ObjectGrammar(final Class<T> _type, final Property[] _properties) {
            if (_type == null || _properties == null)
                throw new NullPointerException();
            type = _type;
            properties = _properties;
            for (Property prop : properties)
                prop.bind(this);
        }
        
        public Class<T> getType() { return type; }
        
        public Property[] getProperties() { return properties; }

        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(final InverseScope scope) {
            return new ObjectGrammar<T>(type, Property.inverse(properties, scope));
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public T generate(final GenerateState b) {
                        
            List<Object> constructorParms = new ArrayList<Object>();
            for (final Property property : properties)
                if (property.constructorParameter != -1) {
                    while (constructorParms.size() < property.constructorParameter+1)
                        constructorParms.add(null);
                    constructorParms.set(property.constructorParameter, property.pattern.generate(b));
                }
            
            Multimethod m = Multimethod.create(type, "<init>", constructorParms.size());
            T r = (T)m.invokeStatic(constructorParms.toArray());

            for (final Property property : properties)
                property.generate(r, b);

            return r;
        }

        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), type, properties); }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof ObjectGrammar)) return false;
            final ObjectGrammar<?> that = (ObjectGrammar<?>) _that;
            if (!CompareUtil.equals(this.type, that.type))
                return false;
            if (!Arrays.equals(this.properties, that.properties))
                return false;
            return true;
        }
        
        @Override
        public String toString() {
            return String.valueOf(type.getName()) + "(" + Property.toString(properties) + ")";
        }
    }

    /**
     *
     */
    public static class Property {

       private final String name;
       private final int constructorParameter;
       private final Grammar pattern;
       
       ObjectGrammar<?> grammar;
       Multimethod getter = null;
       Multimethod setter = null;
       
       public Property(final String _name, final int _constructorParameter, final Grammar _pattern) {
           name = _name;
           constructorParameter = _constructorParameter;
           pattern = _pattern;
           
           if (name == null && constructorParameter == -1)
               throw new AssertionError("Bad prop(): both name and constructor parameter index are unspecified");
           
           if (pattern == null)
               throw new NullPointerException();
       } 
       
       public String getName() { return name; }
       
       public Grammar getPattern() { return pattern; }
       
       /**
        * Called by ObjectGrammar when a property is added.
        */
       <T> void bind(final ObjectGrammar<T> _grammar) {
           if (grammar != null && grammar != _grammar)
               throw new AssertionError("Property " + name
                       + " is already bound to another obj() grammar - "
                       + "can't use a prop() in two obj() grammars at once!");
           grammar = _grammar;
       }

       public static Property[] inverse(final Property[] properties, final InverseScope scope) {
           final Property[] r = new Property[properties.length];
           for (int i=0; i<properties.length; i++)
               r[i] = properties[i].inverse(scope);
           return r;
       }

       public Property inverse(final InverseScope scope) {
           return new Property(name, constructorParameter, pattern.inverse(scope));
       }
       
       protected void generate(final Object o, final GenerateState b) {
           if (constructorParameter == -1)
               getSetter().invoke(o, pattern.generate(b));
       }
       
       public Multimethod getGetter() {
           if (getter == null) {
               final String getterName = "get"
                       + Character.toUpperCase(name.charAt(0))
                       + name.substring(1);
               getter = Multimethod.create(grammar.type, getterName, 0);
           }
           return getter;
       }
       
       private Multimethod getSetter() {
           if (setter == null) {
               final String setterName = "set"
                       + Character.toUpperCase(name.charAt(0))
                       + name.substring(1);
               setter = Multimethod.create(grammar.type, setterName, 1);
           }
           return setter;
       }

       @Override
       public int hashCode() {
           return CompareUtil.hashCode(getClass(), name, 
                   constructorParameter, pattern);
       }

       @Override
       public boolean equals(Object _that) {
           if (!(_that instanceof Property)) return false;
           final Property that = (Property) _that;
           if (!CompareUtil.equals(this.constructorParameter, that.constructorParameter))
               return false;
           if (!CompareUtil.equals(this.name, that.name))
               return false;
           if (!CompareUtil.equals(this.pattern, that.pattern))
               return false;
           return true;
       }

       public static String toString(final Property[] properties) {
           final StringBuilder r = new StringBuilder();
           for (int i=0; i<properties.length; i++) {
               if (i>0) r.append(", ");
               r.append(properties[i]);
               
           }
           return r.toString();
       }
       
       @Override
       public String toString() { return name + ":" + pattern; }
   }

    /**
     *
     */
    public final static class SeqGrammar extends Grammar {
        private final Grammar lhs;
        private final Grammar rhs;

        public SeqGrammar(final Grammar _lhs, final Grammar _rhs) {
            lhs = _lhs;
            rhs = _rhs;
            if (lhs == null || rhs == null)
                throw new NullPointerException();
        }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        public Grammar getLhs() { return lhs; }
        public Grammar getRhs() { return rhs; }
        
        @Override
        public Grammar seq(Grammar that) {
            // optimization: A seq () == A
            if (that.equals(empty()))
                return this;
            else
                return super.seq(that);
        }

        @Override
        public Grammar inverse(final InverseScope scope) {
            return new SeqGrammar(lhs.inverse(scope), rhs.inverse(scope));
        }
        
        @Override
        protected Object generate(final GenerateState parse) {
            final Object lhsV = lhs.generate(parse);
            final Object rhsV = rhs.generate(parse);
            return GrammarUtil.concat(lhsV, rhsV);
        }

        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), lhs, rhs); }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof SeqGrammar)) return false;
            final SeqGrammar that = (SeqGrammar) _that;
            if (!CompareUtil.equals(this.lhs, that.lhs)) return false;
            if (!CompareUtil.equals(this.rhs, that.rhs)) return false;
            return true;
        }

        @Override
        public String toString() {
            return "(" + lhs.toString() + " " + rhs.toString() + ")";
        }
    }

    /**
     *
     */
    public final static class OrGrammar extends Grammar {
        private final Grammar lhs;
        private final Grammar rhs;

        public OrGrammar(final Grammar _lhs, final Grammar _rhs) {
            lhs = _lhs;
            rhs = _rhs;
            if (lhs == null || rhs == null)
                throw new NullPointerException();
        }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        public Grammar getLhs() { return lhs; }
        public Grammar getRhs() { return rhs; }
        
        @Override
        public Grammar or(Grammar rhs) {
            if (equalsOrIsPartOfOr(rhs))
                return this;
            // XXX optimize: if LHS already contains RHS as a direct chained OR, return this.
            return super.or(rhs);
        }

        @Override
        public Grammar inverse(final InverseScope scope) {
            return new OrGrammar(lhs.inverse(scope), rhs.inverse(scope));
        }

        @Override
        protected Object generate(final GenerateState b) {
            return b.getOrGenerator().generate(rhs, lhs, b);
        }

        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), lhs, rhs);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof OrGrammar)) return false;
            final OrGrammar that = (OrGrammar) _that;
            if (!CompareUtil.equals(this.lhs, that.lhs)) return false;
            if (!CompareUtil.equals(this.rhs, that.rhs)) return false;
            return true;
        }

        @Override
        protected boolean equalsOrIsPartOfOr(Grammar v) {
            return lhs.equalsOrIsPartOfOr(v) || rhs.equalsOrIsPartOfOr(v);
        }

        @Override
        public String toString() {
            return "(" + lhs.toString() + " | " + rhs.toString() + ")";
        }
    }
    
    /**
     * 
     */
    public static class NotGrammar extends Grammar {

        private final Grammar g;
        
        public NotGrammar(Grammar _g) 
        { g = _g; if (g == null) throw new NullPointerException(); }

        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(InverseScope scope) {
            return new NotGrammar(g.inverse(scope));
        }

        @Override
        protected Object generate(GenerateState b) {
            // XXX is this reasonable?
            return Collections.EMPTY_LIST;
        }

        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), g);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof NotGrammar))
                return false;
            NotGrammar that = (NotGrammar)_that;
            if (!CompareUtil.equals(this.g, that.g)) return false;
            return true;
        }
        
        @Override
        public String toString() {
            return "!" + g;
        }
    }
    
    /**
     * 
     */
    public static class AndGrammar extends Grammar {
        private final Grammar lhs;
        private final Grammar rhs;
        
        public AndGrammar(Grammar _lhs, Grammar _rhs) {
            lhs = _lhs;
            rhs = _rhs;
        }
        
        public Grammar getLhs() { return lhs; }
        
        public Grammar getRhs() { return rhs; }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        
        @Override
        public Grammar inverse(InverseScope scope) {
            return new AndGrammar(lhs.inverse(scope), rhs.inverse(scope));
        }
        
        @Override
        protected Object generate(GenerateState b) {
            return lhs.generate(b);
            // XXX parse result with RHS, ensure that it matches!?
            
            // XXX otherwise, this isn't accurate, is it?
        }
        
        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), lhs, rhs);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof AndGrammar)) return false;
            AndGrammar that = (AndGrammar)_that;
            if (!CompareUtil.equals(this.lhs, that.lhs)) return false;
            if (!CompareUtil.equals(this.rhs, that.rhs)) return false;
            
            return true;
        }

        @Override
        public String toString() {
            return "("+lhs+" & "+rhs+")";
        }  
    }

    /**
     * 
     */
    public static class RecurseGrammar extends Grammar {
        private String ruleName;
        
        public RecurseGrammar(String _ruleName)
        { 
            ruleName = _ruleName; 
            if (ruleName == null) throw new NullPointerException();
        }
        
        public String getRuleName() { return ruleName; }

        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(InverseScope scope) {
            return this;
        }

        @Override
        protected Object generate(GenerateState b) {
            return b.getEnclosingRule(ruleName).generate(b);
            // throw new UnsupportedOperationException("RECURSE not allowed in build expression");
        }

        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), ruleName);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof RecurseGrammar)) return false;
            final RecurseGrammar that = (RecurseGrammar) _that;
            if (!CompareUtil.equals(this.ruleName, that.ruleName)) return false;
            return true;
        }
        
        @Override
        public String toString() {
            return "recurse(\""+ruleName+"\")";
        }
    }

    /**
     * 
     */
    public static class WrapGrammar<I,O> extends Grammar {
        private final Grammar inputGrammar;
        private final GrammarFn<I,O> fn;

        public WrapGrammar(final Grammar _g, final GrammarFn<I,O> _fn) {
            inputGrammar = _g;
            fn = _fn;
            if (inputGrammar == null || fn == null) throw new NullPointerException();
        }
        
        public Grammar getInputGrammar() {
            return inputGrammar; 
        }
        
        public GrammarFn<I,O> getFn() { return fn; }

        public <I_,O_> O_ accept(GrammarVisitor<I_,O_> v, I_ _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(final InverseScope scope) {
            // XXX not quite good enough.  inverse() inverse() should reveal the original grammar, not the default...
            GrammarFn<O, I> inverseFn = fn.inverse();
            return new WrapGrammar<O,I>(inverseFn.getSourceGrammar(inputGrammar), inverseFn);
        }

        @Override
        protected Object generate(final GenerateState b) {
            // generate generates the source grammar: the semantic value is irrelevant.
            return inputGrammar.generate(b);
        }

        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), fn, inputGrammar);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof WrapGrammar)) return false;
            final WrapGrammar<?,?> that = (WrapGrammar<?,?>) _that;
            if (!CompareUtil.equals(this.inputGrammar, that.inputGrammar))
                return false;
            if (!CompareUtil.equals(this.fn, that.fn)) return false;
            return true;
        }
        
        @Override
        public String toString() { return inputGrammar + ".wrap(" + fn.getClass().getName() + ")"; }
    }
    
    /**
     * 
     */
    public static class RuleGrammar extends Grammar {
        private final String name;
        private final Grammar body;
        
        public RuleGrammar(String name, Grammar body) {
            this.name = name;
            this.body = body;
            if (name == null) throw new NullPointerException();
            if (body == null) throw new NullPointerException();
        }
    
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        public String getName() { return name; }
        
        public Grammar getBody() { return body; }
        
        @Override
        public Grammar inverse(InverseScope scope) {
            return new RuleGrammar(name, body.inverse(scope));
        }
    
        @Override
        protected Object generate(GenerateState r) {
            r = r.addRule(this);
            return body.generate(r);
        }
        
        @Override
        public int hashCode() { return CompareUtil.hashCode(getClass(), body, name); }
    
        @Override
        public boolean equals(final Object _that) {
            if (!(_that instanceof RuleGrammar)) return false;
            final RuleGrammar that = (RuleGrammar) _that;
            if (!CompareUtil.equals(this.body, that.body)) return false;
            if (!CompareUtil.equals(this.name, that.name)) return false;
            return true;
        }
        
        @Override
        public String toString() { return name; }
    }

    
    /**
     * 
     * 
     *
     */
    public static class CanonicalGrammar extends Grammar {
        
        // ------------------------------------------------------------------------
        // Implementation classes
        
        private final Grammar real;
        private final Grammar canonical;
        
        public CanonicalGrammar(Grammar _real, Grammar _canonical) {
            real = _real;
            canonical = _canonical;
            if (real == null || canonical == null)
                throw new NullPointerException();
        }
        
        public Grammar getReal() { return real; }
        
        public <I,O> O accept(GrammarVisitor<I,O> v, I _) { return v.visit(this, _); }

        @Override
        public Grammar inverse(InverseScope scope) {
            return new CanonicalGrammar(real.inverse(scope), canonical.inverse(scope));
        }
        
        @Override
        protected Object generate(GenerateState b) {
            return canonical.generate(b);
        }
        
        @Override
        public int hashCode() {
            return CompareUtil.hashCode(getClass(), real, canonical);
        }

        @Override
        public boolean equals(Object _that) {
            if (!(_that instanceof CanonicalGrammar)) return false;
            CanonicalGrammar that = (CanonicalGrammar)_that;
            if (!CompareUtil.equals(this.real, that.real)) return false;
            if (!CompareUtil.equals(this.canonical, that.canonical)) return false;
            return true;
        }

        @Override
        public String toString() {
            return real + ".canonical("+canonical+")";
        }
        
    }
    
    public static class InverseScope {

        protected Map<String,Grammar> labels = new HashMap<String,Grammar>() ;

    }
}
