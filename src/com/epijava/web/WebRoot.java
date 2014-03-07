/*
 *
 *
 */
package com.epijava.web;

import com.epijava.build.*;

/**
 *
 **/
public class WebRoot {
    
    public UriHandler getUriHandler() {
	return new UriHandler() {
	    public Object handleUri(String uri) {
		return new UriCallLanguage().run(WebRoot.this, uri);
	    }
	};
    }
    
    public Object index() {
	return "Hello, world!  This is the default index page!";
    }
    
    public void quit() {
	// XXX do some security here XXX
	System.out.println("Shutting down by /quit request");
	System.exit(1);
    }

    /**
     *
     **/
    public EpiBuilder build() {
	return new EpiBuilder();
    }
    
}
