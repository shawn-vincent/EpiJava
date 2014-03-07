/*
 *
 *
 */
package com.epijava.web;

import org.slf4j.*;

import com.epijava.lang.reflect.*;
import com.epijava.util.*;


/**
 * Parses URIs, interpreting the result as Java calls.
 **/
public class UriCallLanguage {

    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory.getLogger(UriCallLanguage.class);

    /**
     *
     **/
    public Object run(Object rootScope, String expr) {
	return run(rootScope, rootScope, expr);
    }

    public Object run(Object rootScope, Object scope, String expr) {

	// try letting the object handle it itself
	if (scope instanceof UriHandler)
	    return ((UriHandler)scope).handleUri(Uri.unescapeString(expr));


	if (expr.startsWith("/")) expr = expr.substring(1);

	String rest = expr;

	int nextSlashIdx = rest.indexOf('/');
	String segment = nextSlashIdx == -1 ? rest : rest.substring(0, nextSlashIdx);
	rest = nextSlashIdx == -1 ? null : rest.substring(nextSlashIdx);
	
	// convert segment to method name.
	String methodName = segment;
	if (methodName.length() == 0)
	    methodName = "index";
	methodName = methodName.replaceAll("[`~!@#$%^&*()_+={}|\\;':\",./<>?]", "_");
	
	// XXX parse args here as well, if possible, either with ? syntax or () syntax.
	
	Multimethod method;

	try {
	    method = Multimethod.create(scope.getClass(), methodName, 0);
	    scope = method.invoke(scope);
	} catch (NotFoundReflectException ex) {
	    // XXX should this be done inside the multimethod?

	    

	    throw ex;
	}

	// XXX try casting scope to MethodNotFoundHandler if not found


	if (rest != null)
	    return run(rootScope, scope, rest);
	else
	    return scope;
    }

}