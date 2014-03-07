/*
 *
 *
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * A Java import declaration.
 *
 * Can be a static import (import static foo.bar.Baz.*), an 'import
 * all' (import foo.bar.*), or just a simple import (import
 * foo.bar.Baz)
 **/
public class Import extends Expression {
    private final QualifiedName name; // XXX change to PackageReference
    private final boolean importAll;
    private final boolean staticImport;

    public Import(Locus _locus, QualifiedName _name, boolean _importAll,
			     boolean _staticImport) {
    	super (_locus);
	name = _name; importAll = _importAll; staticImport = _staticImport;
    }

    @AstValue
    public QualifiedName getName() { return name; }
    public boolean isImportAll() { return importAll; }
    public boolean isStaticImport() { return staticImport; }
}