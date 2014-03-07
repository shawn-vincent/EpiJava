/*
 *
 *
 */
package com.epijava.lang.parser;

import com.epijava.lang.grammar.*;
import com.epijava.lang.tree.*;

import java.io.*;
import org.antlr.runtime.*;

/**
 * Entry point into the Java parser.
 **/
public class EpiParser {
    
    /**
     * Parse the literal program source specified.
     * 
     * @param sourceCode - EpiJava source code as a String
     */
    public CompilationUnit parseLiteralSource (String sourceCode) throws EpiParseException {
        return parse("<program text>", new StringReader(sourceCode));
    }
    
    /**
     * Parse EpiJava source code from the given File
     */
    public CompilationUnit parse (File f) throws EpiParseException {
        try {
            return parse(f.getPath(), new BufferedReader(new FileReader(f)));
        } catch (FileNotFoundException ex) {
            throw new EpiParseException(f.getPath()+": could not find file", ex);
        }
    }

    /**
     * Parse EpiJava source code from the given Reader
     * 
     * @param locusModule - user-presentable name of the locus (or context) 
     *  in which the source code appears.  Used for error messages.
     */
    public CompilationUnit parse (String locusModule, Reader in)
	throws EpiParseException
    {
        EpiJavaLexer lexer;
	try {
	    lexer = new EpiJavaLexer(new ANTLRReaderStream(in));
	} catch (IOException ex) {
	    throw new EpiParseException(locusModule+": could not read", ex);
	}
        TokenStream tokens = new CommonTokenStream(lexer);

        EpiJavaParser parser = new EpiJavaParser(tokens);
	parser.setLocusModule(locusModule);
	try {
	    return parser.compilationUnit();
	} catch (RecognitionException ex) {
	    throw new EpiParseException(locusModule+": parse exception", ex);
	}
    }

}