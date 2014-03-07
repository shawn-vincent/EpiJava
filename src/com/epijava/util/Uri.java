/*
 * Uri.java
 *
 * Copyright (c) 1996-2007 Exalt Corp.  All Rights Reserved.
 */

/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is the org.entropy Entropy Utility Library.
 *
 * The Initial Developer of the Original Code is Exalt, inc.  Portions
 * created by Exalt, inc are Copyright (C) 1996-2007 Exalt, inc. All Rights
 * Reserved.
 *
 * Contributor(s): Exalt, inc; David Ziegler; Shawn Vincent; Arie Gurfinkel.
 *
 * ***** END LICENSE BLOCK ***** */
package com.epijava.util;

import java.io.*;
import java.net.*;
import java.util.*;



/**
 * <p>Represents and manipulates Uniform Resource Identifiers, as
 * defined by RFC 2396.</p>
 *
 * <p>XXX Maybe parse userinfo, host, port from server-based
 * authorities.</p>
 *
 * XXX Consider using Commons HTTPClient URI:
 *   http://jakarta.apache.org/commons/httpclient/apidocs/org/apache/commons/httpclient/URI.html
 *
 *   Although the Commons one seems kindof sad and confused.
 *   org.entropy.Uri is still the best one I've seen (not to say there
 *   isn't better ones out there, but for now, this is it.)
 *
 * 
 **/
public class Uri implements Comparable<Uri>, Serializable
{
    private static final long serialVersionUID = 1L;

    public static final Uri[] EmptyArray = new Uri[0];

  /**
   * Characters which are allowed within an URI, but have special meaning.
   **/
  public static final String Reserved = ";/?:@&=+$,";

  /** Alphabetics and digits. **/
  public static final String Lowalpha = "abcdefghijklmnopqrstuvwxyz";
  public static final String Hialpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String Alpha = Lowalpha + Hialpha;
  public static final String Digit = "0123456789";
  public static final String Alphanum = Alpha + Digit;

  /** A limited set of punctuation marks and symbols **/
  public static final String Mark = "-_.!~*'()";

  /** 
   * Unreserved characters can be escaped without changint the
   * semantics of the URI, but this should not be done unless the URI
   * is being used in a context that does not allow the unescaped
   * character to occur. 
   **/
  public static final String Unreserved = Alphanum + Mark;

  public static final String ValidFirstSchemeChars = Alpha;
  public static final String ValidSchemeChars = Alpha + Digit + "+-.";

  /** Valid drive letters on Windows */
  public static final String ValidDriveLetters = Alpha;

  String scheme;
  String authority;
  String path;
  String query;
  String fragment;

  transient String cachedToString = null;

  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------
  // -------------------------------------------------------------------------

  /**
   * Decodes the given parameter from the given URL query.
   *
   * The query is assumed to be URL-encoded.
   *
   * This method is relatively slow (it parses the whole query)
   *
   * Returns null if parm is missing.
   **/
  public static String decodeUriQueryParameter (String query, String parmName)
  {
    if (query == null) return null;

    // --- decode the query: funny characters unescaped, etc.
    try {
      query = URLDecoder.decode (query, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      throw new AssertionError ();
    }

    // --- strip leading ? if present.
    if (query.startsWith ("?")) query = query.substring (1);

    // --- break at '&'.
    String[] parms = tokenizeString (query, "&?", false);

    // --- search for the query parameter.
    for (int i=0; i<parms.length; i++)
      if (parms[i].startsWith (parmName+"="))
	return parms[i].substring ((parmName+"=").length ());

    return null;
  }

  private static String[] tokenizeString (String source, String delimiters,
					 boolean includeDelimiters)
  {
      List<String> tokens = new ArrayList<String>();
      StringTokenizer tokenizer = new StringTokenizer (source, delimiters,
						       includeDelimiters);
      while (tokenizer.hasMoreTokens ())
	  tokens.add(tokenizer.nextToken());
      
      return tokens.toArray(new String[0]);
  }

  // -------------------------------------------------------------------------
  // ---- Make an URI --------------------------------------------------------
  // -------------------------------------------------------------------------

//   /**
//    * @builtin xf:anyURI
//    **/
//   public static Uri asUri (StringValue uriStr) throws MalformedUriException
//   { return new Uri (uriStr.stringValue ()); }

  public Uri (String uriStr) throws MalformedUriException
  {
    if (uriStr == null) throw new NullPointerException ("Got null uriStr!");
    parseFrom (uriStr, true);
    cachedToString = uriStr;
  }

  /**
   * Create an URI for the given URL object.
   **/
  public Uri (URL url)
  {
    UriParser parser = new UriParser (url.getFile ());
    String path = parser.consumePath ();
    String query = parser.consumeQuery ();

    initWith (url.getProtocol (),
	      url.getHost (),
	      path,
	      query,
	      url.getRef ());
  }

  /**
   * <p>Create an URI for a file </p>
   *
   * <p>Creates a relative URI. </p>
   **/
  public Uri (File f) { this (null, null, f.getPath ()); }

  /**
   * <p>Create an URI given a number of components, </p>
   **/
  public Uri (String _scheme, String _authority, String _path)
  { this (_scheme, _authority, _path, null, null); }

  /**
   * <p>Create an URI given a number of components, </p>
   **/
  public Uri (String _scheme, String _authority,
	      String _path, 
	      String _query, String _fragment)
  { initWith (_scheme, _authority, _path, _query, _fragment); }

  protected void parseFrom (String uriStr, boolean unescape) 
    throws MalformedUriException
  {
    UriParser parser = new UriParser (uriStr);

    String scheme = parser.consumeScheme ();
    // XXX should schemes also be unescaped ?
    if (!Uri.isValidScheme (scheme)) 
      throw new MalformedUriException ("Invalid scheme '"+scheme+"'");
    String authority = parser.consumeAuthority ();
    if (unescape) authority = unescapeString (authority);
    String path = parser.consumePath ();
    if (unescape) path = unescapeString (path);
    String query = parser.consumeQuery ();
    if (unescape) query = unescapeString (query);
    String fragment = parser.consumeFragment ();
    if (unescape) fragment = unescapeString (fragment);

    initWith (scheme, authority, path, query, fragment);
  }

  private void initWith (String _scheme, String _authority, 
			 String _path, 
			 String _query, String _fragment)
  {
    if (_path == null) 
      throw new NullPointerException
	("Path must be defined in all URIs (relative and absolute)");

    scheme = _scheme;


    // XXX think harder...
    if (_authority != null && _authority.length () == 0) _authority = null;


    authority = _authority;
    path = _path;
    query = _query;
    fragment = _fragment;
  }

  // -------------------------------------------------------------------------
  // ---- Make new, slightly different URI -----------------------------------
  // -------------------------------------------------------------------------

  public Uri replaceScheme (String newScheme)
  { 
    return new Uri (newScheme, getAuthority (), getPath (), 
		    getQuery (), getFragment ()); 
  }

  public Uri replaceAuthority (String newAuthority)
  { 
    return new Uri (getScheme (), newAuthority, getPath (), 
		    getQuery (), getFragment ()); 
  }

  public Uri replacePath (String newPath)
  { 
    return new Uri (getScheme (), getAuthority (), newPath, 
		    getQuery (), getFragment ()); 
  }

  public Uri replacePathSuffix (String oldSuffix, String newSuffix)
  { 
    return new Uri (getScheme (), getAuthority (),
		    replaceSuffix (getPath(), oldSuffix, newSuffix),
		    getQuery (), getFragment ()); 
  }

  /**
   * 's' must be a string that ends with the suffix 'oldSuffix'.
   * This method then return 's', modified such that 'oldSuffix' is
   * replaced by 'newSuffix'.
   *
   * @exception IllegalArgumentException 
   *            if 's' does not end with 'oldSuffix'.
   **/
  private static String replaceSuffix (String s, 
				      String oldSuffix, String newSuffix)
  {
    if (!s.endsWith (oldSuffix))
      throw new IllegalArgumentException 
	("'"+s+"' must end with '"+oldSuffix+"'");

    s = s.substring (0, s.length () - oldSuffix.length ());

    return s + newSuffix;
  }

  public Uri replaceQuery (String newQuery)
  { 
    return new Uri (getScheme (), getAuthority (), getPath (), 
		    newQuery, getFragment ()); 
  }

  /**
   * Add a new parameter to the end of the query string.
   *
   * This method assumes standard URI parameters, of the form
   * ?name=value&name=value
   *
   * XXX allow specifying different delimiters, or even lists of delimiters
   **/
  public Uri addUriParameter (String name, String value)
  { 
    String query = getQuery ();
    String newQuery;
    if (query == null || query.length () == 0)
      newQuery = name + "=" + value;
    else
      newQuery = query + "&" + name + "=" + value;

    return replaceQuery (newQuery);
  }

  /**
   * If the specified parameter is already present, it is replaced by
   * the new value.  Otherwise, append a new parameter to the end.
   *
   * This method assumes standard URI parameters, of the form
   * ?name=value&name=value
   *
   * XXX allow specifying different delimiters, or even lists of delimiters
   **/
  public Uri setUriParameter (final String name, final String value)
  { 
    String query = getQuery ();

    String newQuery;
    if (query == null || query.length () == 0)
      {
	newQuery = name + "=" + value;
      }
    else
      {
	// --- search for a parm of the form 'name=value' or 'name',
	//   - where name is the name specified for this method.
	//   - Replace this parm with the new name, value pair.
	//   - If none is found, add it to the end.
	boolean replacedParm = false;
	StringBuffer newQueryBuffer = new StringBuffer ();
	StringTokenizer tok = new StringTokenizer (query, "&", true);
	while (tok.hasMoreTokens ())
	  {
	    String token = tok.nextToken ();
	    if (token.equals ("&"))
	      {
		newQueryBuffer.append (token);
	      }
	    else
	      {
		if (token.startsWith (name))
		  {
		    String sawName;
		    //String sawValue;
		    int eqIndex = token.indexOf ('=');
		    if (eqIndex != -1)
		      {
			sawName = token.substring (0, eqIndex);
			//sawValue = token.substring (eqIndex+1);
		      }
		    else
		      {
			sawName = token;
			//sawValue = null;
		      }

		    if (sawName.equals (name))
		      {
			newQueryBuffer.append (name);
			newQueryBuffer.append ('=');
			newQueryBuffer.append (value);
			replacedParm = true;
		      }
		    else
		      {
			newQueryBuffer.append (token);
		      }
		  }
		else
		  {
		    newQueryBuffer.append (token);
		  }
	      }
	  }

	if (!replacedParm)
	  {
	    newQueryBuffer.append ('&');
	    newQueryBuffer.append (name);
	    newQueryBuffer.append ('=');
	    newQueryBuffer.append (value);
	    replacedParm = true;
	  }
	    
	newQuery = newQueryBuffer.toString ();
      }

    return replaceQuery (newQuery);
  }

  public Uri replaceFragment (String newFragment)
  { 
    return new Uri (getScheme (), getAuthority (), getPath (), 
		    getQuery (), newFragment); 
  }

  public boolean hasDriveLetter ()
  { 
    String p = getPath ();
    return 
      p.length () >= 4 &&
      p.charAt (0) == '/' &&
      ValidDriveLetters.indexOf (p.charAt (1)) != -1 &&
      p.charAt (2) == ':' &&
      p.charAt (3) == '/';
  }

  public Uri removeDriveLetter ()
  {
    if (hasDriveLetter ())
      return new Uri (getScheme (), getAuthority (), 
		      getPath ().substring (3),
		      getQuery (), getFragment ()); 
    else
      return this;
  }

  // -------------------------------------------------------------------------
  // ---- Fetch information about this URI -----------------------------------
  // -------------------------------------------------------------------------

  public String getScheme () { return scheme; }
  public String getNormalizedScheme () 
  { 
    String s = getScheme ();
    if (s == null) return null;
    return s.toLowerCase ();
  }

  public String getAuthority () { return authority; }
  public String getEscapedAuthority () 
  { return escapeString (getAuthority ()); }
  public String getNormalizedAuthority ()
  { 
    String a = getAuthority ();
    if (a == null) return null;
    return a.toLowerCase ();
  }

  public String getPath () { return path; }
  public String getEscapedPath () 
  { return escapeString (getPath ()); }

  public String getQuery () { return query; }
  public String getEscapedQuery () 
  { return escapeString (getQuery ()); }

  public String getFragment () { return fragment; }
  public String getEscapedFragment () 
  { return escapeString (getFragment ()); }

//   public void dump (IndentPrintWriter out)
//   {
//     out.println ("   scheme == "+getScheme ());
//     out.println ("   authority == "+getAuthority ());
//     out.println ("   path == "+getPath ());
//     out.println ("   query == "+getQuery ());
//     out.println ("   fragment == "+getFragment ());
//   }

  /**
   * If scheme is non-null, we have an absolute URI.
   **/
  public boolean isRelative () { return scheme == null; }

  /**
   * Returns true iff this URI is not relative
   **/
  public boolean isAbsolute () { return !isRelative (); }

  // -------------------------------------------------------------------------
  // ---- Comparison ---------------------------------------------------------
  // -------------------------------------------------------------------------

  /**
   * HashCode defined such that if two URIs compare equal using the
   * equals method, their hashcodes will be identical.
   **/
  public int hashCode ()
  {
    int h = 0;
    h = catHash (h, getNormalizedScheme ());
    h = catHash (h, getNormalizedAuthority ());
    h = catHash (h, getPath ());
    h = catHash (h, getQuery ());
    h = catHash (h, getFragment ());
    return h;
  }

  /**
   * Add a value's hashcode into an existing hashcode.
   *
   * These types are sufficient: Java type promotion will fill in the
   * rest.
   */
  //private static int catHash (int hc, boolean v)
  //{ return catHash (hc, v ? 1 : 0); }
  private static int catHash (int hc, int v)
  { return (hc << 3) + v + 101; }
  //private static int catHash (int hc, long v)
  //{ return catHash (catHash (hc, (int)(v & 0xFFFFFFFF)), (int)(v >>> 32)); }
  //private static int catHash (int hc, double v)
  //{ return catHash (hc, Double.doubleToLongBits (v)); }

  /**
   * Adds the result of calling hashCode () on the given object into
   * the hashcode.
   **/
  private static int catHash (int hc, Object v)
  { 
    // Note that 389407 is a very important constant.  DO NOT CHANGE.  :)
    // XXX just kidding.
    return catHash (hc, v == null ? 389407 : v.hashCode ()); 
  }


  /**
   * <p>Two URIs are considered equivalent using this method if:
   *   (1) Their scheme and authorities are identical, case insensitive.
   *   (2) Their path, query, and fragment are identical, case sensitive.
   * </p>
   *
   * <p>This is similar to the definition of equivalence in section 6
   * of RFC 2396 ("URI Normalization and Equivalence"), with the
   * exception that we do not normalize redundant port numbers </p>
   **/
  public boolean equals (Object _that)
  {
    if (!(_that instanceof Uri)) return false;

    Uri that = (Uri)_that;
    if (!equalsIgnoreCase (getScheme (), that.getScheme ())) return false;
    if (!equalsIgnoreCase (getAuthority (), that.getAuthority())) return false;
    if (!equals (getPath (), that.getPath ())) return false;
    if (!equals (getQuery (), that.getQuery ())) return false;
    if (!equals (getFragment (), that.getFragment ())) return false;

    return true;
  }

  /**
   * <p>Two URIs are considered equivalent using this method if:
   *   (1) Their scheme and authorities are identical, case insensitive.
   *   (2) Their path, query, and fragment are identical, case sensitive.
   * </p>
   *
   * <p>This is similar to the definition of equivalence in section 6
   * of RFC 2396 ("URI Normalization and Equivalence"), with the
   * exception that we do not normalize redundant port numbers </p>
   **/
  public int compareTo (Uri that)
  {
    int r;
    r = compareIgnoreCase (getScheme (), that.getScheme ());
    if (r != 0) return r;
    r = compareIgnoreCase (getAuthority (), that.getAuthority());
    if (r != 0) return r;
    r = compare (getPath (), that.getPath ());
    if (r != 0) return r;
    r = compare (getQuery (), that.getQuery ());
    if (r != 0) return r;
    r = compare (getFragment (), that.getFragment ());
    if (r != 0) return r;

    return r;
  }

  /**
   * Compares two generic objects as best it can.
   *
   * This method knows about:
   *
   *   - null,
   *
   *   - java.lang.String,
   *
   *   - the JDK1.2 Comparable interface,
   *
   *   and finally, if all of these fail, then:
   *
   *   - compare by class name,
   *
   *   - and finally by identity hash code.
   **/
  @SuppressWarnings("unchecked")
public static int compare (Object self, Object other)
  {
    if (self == null && other == null) return 0;
    if (self == null) return -1;
    if (other == null) return 1;

    Class<? extends Object> selfClass = self.getClass ();
    Class<? extends Object> otherClass = other.getClass ();

    // --- deal with JDK1.2 Comparable.
    if (self instanceof Comparable)
      return ((Comparable<Object>)self).compareTo (other);

    // --- compare classes by name.
    if (selfClass != otherClass)
      return selfClass.getName ().compareTo (otherClass.getName ());

    // --- finally compare identity hash codes.
    return System.identityHashCode (self) - System.identityHashCode (other);
  }

  /**
   * Like 'String.compareToIgnoreCase', but deals with null.
   **/
  private static int compareIgnoreCase (String a, String b)
  {
    if (a == null && b == null) return 0;
    if (a == null) return -1;
    if (b == null) return 1;

    return a.compareToIgnoreCase (b);
  }

  /** Utility method */
  private static boolean equalsIgnoreCase (String a, String b)
  {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    return a.equalsIgnoreCase (b);
  }

  /** Utility method */
  private static boolean equals (String a, String b)
  {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    return a.equals (b);
  }

  // -------------------------------------------------------------------------
  // ---- Externalizing URIs. ------------------------------------------------
  // -------------------------------------------------------------------------

  public String toStringNoFragment ()
  {
    StringBuffer out = new StringBuffer ();
    if (scheme != null) 
      { out.append (getScheme ()); out.append (':'); }
    if (authority != null)
      { out.append ("//"); out.append (getEscapedAuthority ()); }
    out.append (getEscapedPath ());
    if (query != null)
      { out.append ('?'); out.append (getEscapedQuery ()); }
    return out.toString ();
  }

  public String tag () { return normalizedString (); }

  public String conciseTag ()
  {
    return getLastPathSegment ();
  }

  /**
   * Returns that component of the Uri path that corresponds to the
   * last filename.
   **/
  public String getLastPathSegment ()
  {
    String s = getPath ();
    int lastSlash = s.lastIndexOf ("/");
    if (lastSlash == -1) return s;

    if (lastSlash == s.length ())
      {
	lastSlash = s.lastIndexOf (s, lastSlash-1);
	if (lastSlash == -1) return s;
      }

    return s.substring (lastSlash+1);
  }

  public String normalizedString ()
  {
    Uri relative = calculateRelativeUri (getCurrentDirectory (), this);
    return relative.toString ();
  }

  public String toFileName ()
  {
    // XXX deal with file:///c:/... type stuff...
    // XXX normalize slashes to system-specific ones??
    return getPath ();
  }

  public URL toJavaUrl ()
  {
    // XXX
    try {
      return new URL (asString ());
    } catch (MalformedURLException ex) {
	throw (AssertionError) new AssertionError ("XXX fix me.").initCause(ex);
    }
  }
  /** @deprecated */
  public URL toUrl () { return toJavaUrl (); }

  public URI toJavaUri ()
  {
    // XXX
    try {
      return new URI (asString ());
    } catch (URISyntaxException ex) {
      throw(AssertionError) new AssertionError ("XXX fix me.").initCause(ex);
    }
  }

  public String toString () { return asString (); }
  public String asString ()
  {
    if (cachedToString == null)
      {
	StringBuffer out = new StringBuffer ();
	if (scheme != null) 
	  { out.append (getScheme ()); out.append (':'); }
	if (authority != null)
	  { out.append ("//"); out.append (getEscapedAuthority ()); }
	out.append (getEscapedPath ());
	if (query != null)
	  { out.append ('?'); out.append (getEscapedQuery ()); }
	if (fragment != null)
	  { out.append ('#'); out.append (getEscapedFragment ()); }

	cachedToString = out.toString ();
      }
    return cachedToString;
  }

  public String asStringNoEscape ()
  {
    if (cachedToString == null)
      {
	StringBuffer out = new StringBuffer ();
	if (scheme != null) 
	  { out.append (getScheme ()); out.append (':'); }
	if (authority != null)
	  { out.append ("//"); out.append (getAuthority ()); }
	out.append (getPath ());
	if (query != null)
	  { out.append ('?'); out.append (getQuery ()); }
	if (fragment != null)
	  { out.append ('#'); out.append (getFragment ()); }

	cachedToString = out.toString ();
      }
    return cachedToString;
  }

  /**
   * Escapes the given string, such that all characters which are not
   * Unreserved (q.v.) are quoted using the %dd escaping mechanism.
   **/
  public static String escapeString (String s)
  {
    if (s == null) return s;
    char[] chars = s.toCharArray ();
    StringBuffer out = new StringBuffer (chars.length * 3);
    for (int i=0; i<chars.length; i++)
      {
	char c = chars[i];
	// XXX this isn't quite right: escaping might need to be done
	// in queries, etc.
	if (Uri.isUnreserved (c) || Uri.isReserved (c))
	  out.append (c);
	else
	  {
	    // XXX encoding?  this is BROKEN.
	    out.append ('%');
	    out.append (toHexString ((int)c, 2, false));
	  }
      }
    return out.toString ();
  }


  private final static char[] BaseDigits = {
    '0' , '1' , '2' , '3' , '4' , '5' ,
    '6' , '7' , '8' , '9' , 'A' , 'B' ,
    'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,
    'I' , 'J' , 'K' , 'L' , 'M' , 'N' ,
    'O' , 'P' , 'Q' , 'R' , 'S' , 'T' ,
    'U' , 'V' , 'W' , 'X' , 'Y' , 'Z'
  };

  /**
   * Convert the given value 'i' into a hexadecimal string.
   * @param i - the number to convert
   * @param len - the required length of the result.  Zero-padding
   *             will be added, if neccessary, to obtain this length.
   * @param add0x - after converting to a hex string, prepend the string
   *             "0x" to the start.
   *
   * @return a wonderfully formatted hexadecimal string.
   */
  private static String toHexString (int i, int len, boolean add0x) 
  {
    char[] buf = new char[34];
    int charPos = 34;

    // --- Do hex conversion
    do {
      buf [--charPos] = BaseDigits[i&0xF];
      i >>>= 4;
    } while (i != 0);

    // --- Add optional leading '0' padding
    while (34-charPos < len)
      buf [--charPos] = '0';

    // --- Add optional leading 0x
    if (add0x)
      {
        buf [--charPos] = 'x';
        buf [--charPos] = '0';
      }

    // --- Build result string
    return new String (buf, charPos, (34 - charPos));
  }

  /**
   *
   **/
  public static String unescapeString (String s) throws MalformedUriException
  {
    if (s == null) return s;

    char[] char2 = new char[2];

    char[] chars = s.toCharArray ();
    StringBuffer out = new StringBuffer (chars.length);

    for (int i=0; i<chars.length; i++)
      {
	char c = chars[i];
	switch (c)
	  {
	  case '%': 
	    {
	      if (i+2 >= chars.length) 
		throw new MalformedUriException 
		  ("Not enough characters for valid octet escape");
	      char2[0] = chars[++i];
	      char2[1] = chars[++i];
	      String char2Str = new String (char2);
	      int octet;
	      try {
		octet = Integer.parseInt (char2Str, 16);
	      } catch (NumberFormatException ex) {
		throw new MalformedUriException 
		  ("Bad octet escape '"+char2Str+"'", ex);
	      }
	      // XXX char encoding???  THIS IS WRONG!!
	      out.append ((char)octet);
	      break;
	    }
	  default:
	    {
	      out.append (c);
	      break;
	    }
	  }
      }

    return out.toString ();
  }

//   public void viewMain (Debugger.DebugStream out)
//   {
//     out.objectBegin (this);
//     out.field ("scheme", scheme);
//     out.field ("authority", authority);
//     out.field ("path", path);
//     out.field ("query", query);
//     out.field ("fragment", fragment);
//     out.objectEnd ();
//   }

  // -------------------------------------------------------------------------
  // ---- Informational utilities about URIs ---------------------------------
  // -------------------------------------------------------------------------

  public static boolean isUnreserved (char c) 
  { return Unreserved.indexOf (c) != -1; }

  public static boolean isReserved (char c) 
  { return Reserved.indexOf (c) != -1; }

  public static boolean isValidScheme (String scheme)
  {
    if (scheme == null) return true;

    int len = scheme.length ();
    for (int i=0; i<len; i++)
      {
	char c = scheme.charAt (i);
	if (i == 0)
	  {
	    if (ValidFirstSchemeChars.indexOf (c) == -1) return false;
	  }
	else
	  {
	    if (ValidSchemeChars.indexOf (c) == -1) return false;
	  }
      }
    return true;
  }
  
  // -------------------------------------------------------------------------
  // ---- Resolve relative URI to absolute URI -------------------------------
  // -------------------------------------------------------------------------

  /**
   * @throws MalformedUriException currently only thrown if the
   * relative URI attempts to '..' its way past the beginning of the
   * base URI.
   **/
  public static Uri resolveRelativeUri (Uri base, Uri relative)
  {
    try {
      return resolveRelativeUri (base, relative, false);
    } catch (UpdirPastRootException ex) {
      throw (AssertionError)new AssertionError
	("Unexpected error: I told a subfunction not to throw an "+
	 "exception, but it did anyway.  Ungrateful git.").initCause(ex);
    }
  }

  public static Uri resolveRelativeUri (Uri base, Uri relative,
					boolean exceptionOnUpdirPastRoot)
    throws UpdirPastRootException
  {
    if (base == null) base = getCurrentDirectory ();

    String baseQuery = base.getQuery ();
    String baseFragment = base.getFragment ();

    // (2): if path is empty and scheme, authority and query are
    // undefined, then it is a reference to the current document.
    if (relative.getPath ().length () == 0 &&
	relative.getScheme () == null &&
	relative.getAuthority () == null &&
	relative.getQuery () == null)
      {
//  	if (relative.getQuery () == null && relative.getFragment () == null)
//  	  return base;

	return 
	  new Uri (base.getScheme (), base.getAuthority (), base.getPath (), 
		   base.getQuery (), relative.getFragment ());
      }
    else
      {
	// otherwise, the reference URI's query and fragment
	// components are defined as found (or not found) within the
	// URI reference, and not inherited from the base URI
	baseQuery = null;
	baseFragment = null;
      }

    // (3): if the scheme component is defined, then the reference is
    // an absolute URI.
    if (relative.getScheme () != null)
      return relative;

    String newPath = relative.getPath ();

    boolean skipToStep7 = false;

    // (4) if the network authority is defined, then the reference is
    // a network path, skip to step 7.
    if (relative.getAuthority () != null) skipToStep7 = true;

    // (5) if the path component begins with a slash character,
    // reference is an absolute path, and we skip to step 7.
    if (relative.getPath ().startsWith ("/")) skipToStep7 = true;

    if (!skipToStep7)
      {
	// (6) we are resolving a relative path reference.
	ParsedPath newParsedPath = new ParsedPath ();
	String basePath = base.getPath ();
	int lastSlash = basePath.lastIndexOf ('/');
	if (lastSlash == -1)
	  basePath = "";
	else
	  basePath = basePath.substring (0, lastSlash+1);

	expandInto (newParsedPath,
		    basePath,
		    true,
		    exceptionOnUpdirPastRoot);
	expandInto (newParsedPath,
		    relative.getPath (),
		    false,
		    exceptionOnUpdirPastRoot);
	newPath = newParsedPath.toString ();
      }

    // (7) combine it all.
    String scheme = base.getScheme ();
    String authority = 
      (relative.getAuthority () != null) ? 
      relative.getAuthority () : base.getAuthority ();
    String path = newPath;
    String query = 
      (relative.getQuery () != null) ? 
      relative.getQuery () : baseQuery;
    String fragment =
      (relative.getFragment () != null) ? 
      relative.getFragment () : baseFragment;

    return new Uri (scheme, authority, path, query, fragment);
  }

  private static void expandInto (ParsedPath path, String pathSegment,
				  boolean stripLastComponent,
				  boolean exceptionOnUpdirPastRoot)
    throws UpdirPastRootException
  {
    StringTokenizer tok = new StringTokenizer (pathSegment, "/", true);
    boolean atStart = true;
    while (tok.hasMoreTokens ())
      {
	String token = tok.nextToken ();

	boolean atEnd = !tok.hasMoreTokens ();
	if (token.equals ("/") && atStart) 
	  {
	    path.gotoRoot ();
	    path.slash ();
	  }
	if (stripLastComponent && atEnd && !token.equals ("/"))
	  {
	    // ignore last component.
	  }
	else
	  {
	    path.apply (token, exceptionOnUpdirPastRoot);
	  }
	atStart = false;
      }
  }

  /**
   * Operations Permitted:
   *    - slash
   *    - ..
   *    - path
   *
   * From state:
   *    case [/]
   *      slash -> append Slash if not already Slash
   *      ..    -> remove Slash if slash, append UpDir
   *      path  -> add path component.
   *      .     -> ignore
   *
   *    case ... ..[/]
   *      slash -> append Slash if not already Slash
   *      ..    -> append Slash if not already Slash, append UpDir 
   *      path  -> append Slash if no Slash, append path component
   *      .     -> ignore
   *
   *    case ... c[/] (normal case)
   *      slash -> append Slash if not already Slash
   *      ..    -> remove Slash if slash, remove last component
   *      path  -> append Slash if no Slash, append path component
   *      .     -> ignore
   **/
  private static class ParsedPath {
    static final String Slash = new String ("/");
    static final String UpDir = new String ("..");

    String[] components = new String[64];
    int count = 0;

    private void add (String component)
    {
      if (count >= components.length)
	{
	  String[] newComponents = new String[components.length*2];
	  System.arraycopy (components, 0, newComponents, 0,components.length);
	  components = newComponents;
	}
      components[count++] = component;
    }

    public void apply (String s, boolean exceptionOnUpdirPastRoot)
      throws UpdirPastRootException
    {
      if (s.equals ("/")) slash ();
      else if (s.equals (".")) currDir ();
      else if (s.equals ("..")) upDir (exceptionOnUpdirPastRoot);
      else component (s);
    }

    public void gotoRoot ()
    {
      count = 0;
    }

    public void slash ()
    {
      // append slash if not already slash (always - case 1, 2, & 3)
      if (count == 0 || components[count-1] != Slash) add (Slash);
    }

    public void currDir ()
    {
      // ignore.
    }

    public void upDir (boolean exceptionOnUpdirPastRoot)
      throws UpdirPastRootException
    {
      //    case [/]
      //       remove Slash if slash, append UpDir
      //    case ... ..[/]
      //       append Slash if not already Slash, append UpDir 
      //    case ... c[/] (normal case)
      //       remove Slash if slash, remove last component

      boolean lastIsSlash = isLastSlash ();
      if (lastIsSlash)
	{
	  if (count == 1) // case 1
	    {
	      if (exceptionOnUpdirPastRoot)
		throw new UpdirPastRootException
		  ("Attempt to '..' past start of URI");
	      count--;       // remove last slash (if slash)
	      add (UpDir);   // append UpDir
	    }
	  else if (components[count-2] == UpDir) // case 2
	    {
	      add (UpDir);   // append UpDir
	    }
	  else // case 3
	    {
	      count--;       // remove last slash (if slash)
	      count--;       // remove last component
	    }
	}
      else
	{
	  if (count == 0) // case 1
	    {
	      if (exceptionOnUpdirPastRoot)
		throw new UpdirPastRootException
		  ("Attempt to '..' past start of URI");
	      add (UpDir);   // append UpDir
	    }
	  else if (components[count-1] == UpDir) // case 2
	    {
	      add (Slash);   // append Slash (if not already slash)
	      add (UpDir);   // append UpDir
	    }
	  else // case 3
	    {
	      count--;       // remove last component
	    }
	}
    }

    public void component (String component)
    {
      if (count == 0 || (count == 1 && isLastSlash ()))
	add (component); // case 1
      else // case 2 & 3
	{
	  // append Slash (if not already slash)
	  if (!isLastSlash ()) add (Slash);
	  // append path component
	  add (component);
	}
    }

    boolean isLastSlash ()
    { return count > 0 && components[count-1] == Slash; }

    public String toString ()
    {
      StringBuffer out = new StringBuffer ();
      for (int i=0; i<count; i++) out.append (components[i]);
      return out.toString ();
    }
  }

  // -------------------------------------------------------------------------
  // ---- Get a canonical version of this URI --------------------------------
  // -------------------------------------------------------------------------

  public static Uri getCanonicalUri (Uri uri)
  { return calculateRelativeUri (getCurrentDirectory (), uri); }

  private static Uri CurrentDirectory = null;
  public static Uri getCurrentDirectory ()
  {
    // Safe to be nonsynchronized, as this is constant static data.
    // Safe to be static, as it depends entirely on current directory,
    //   and JVM does not allow this to be changed.
    if (CurrentDirectory == null)
      {
	// --- the default base URI is the user's current working directory.
	String currentDirectory = System.getProperty ("user.dir");
	currentDirectory = currentDirectory.replace ('\\', '/');
	if (!currentDirectory.endsWith ("/")) currentDirectory+="/";
	CurrentDirectory = new Uri ("file", null, currentDirectory);
      }
    return CurrentDirectory;
  }

  // -------------------------------------------------------------------------
  // ---- Calculate a relative URI from two URIs -----------------------------
  // -------------------------------------------------------------------------

  /**
   * Calculates a relative URI that could be used in a page at 'from',
   * that would point to a page at 'to'.  Tries to optimize the URI
   * somewhat.
   **/
  public static Uri calculateRelativeUri (Uri from, Uri to)
  {
    if (from.isRelative ())
      from = resolveRelativeUri (null, from);

    if (to.isRelative ())
      to = resolveRelativeUri (null, to);

    if (!equalsIgnoreCase (from.getScheme (), to.getScheme ()))
      return to;
    if (!compareAuthority (from.getAuthority (), to.getAuthority ()))
      return to;

    // 1: strip common prefixes.
    char[] fromPath = from.getPath ().toCharArray ();
    char[] toPath = to.getPath ().toCharArray ();
    
    int start = 0;
    int minLength = Math.min (fromPath.length, toPath.length);
    for (start=0; start<minLength; start++)
      if (fromPath[start] != toPath[start]) break;

    // XXX ensure that we broke at a '/' char.
    if (start != 0)
      if (fromPath[start-1] != '/')
	while (fromPath[start-1] != '/') start--;


    // 2: for each '/' in A, output '../'
    StringBuffer out = new StringBuffer ();
    for (int i=start; i<fromPath.length; i++)
      if (fromPath[i] == '/') out.append ("../");

    // 3: output B.
    for (int i=start; i<toPath.length; i++)
      out.append (toPath[i]);

    return new Uri (null, null, // relative URI
		    out.toString (), to.getQuery (), to.getFragment ());
  }

  static boolean compareAuthority (String a, String b)
  {
    return equalsIgnoreCase (a, b);
  }

  // -------------------------------------------------------------------------
  // ---- Convert a filename to an URI ---------------------------------------
  // -------------------------------------------------------------------------

  /**
   * Takes a filename (or URI) on the current system, and turns it
   * into an URI.
   **/
  public static Uri resolveFilenameOrUriToUri (String filenameOrUri)
    throws MalformedUriException
  {
    // XXX handle "." and "./" here: convert to 'new Uri ("")'

    // --- several cases here.
    // Win32 UNC names: //server/share/whatever...
    if (filenameOrUri.startsWith ("//"))
      return resolveFilenameToUri (filenameOrUri);

    // --- deal with stuff with a colon in it.
    int colonIndex = filenameOrUri.indexOf (':');
    if (colonIndex != -1)
      {
	// --- browsers on windows assume that a one-letter protocol handler
	//   - is a drive letter.  Do that, here.
	if (colonIndex == 1)
	  {
	    // Win32 drive-delimited names:  c:myfile.txt
	    char firstChar = filenameOrUri.charAt (0);
	    if (ValidDriveLetters.indexOf (firstChar) != -1)
	      return resolveFilenameToUri (filenameOrUri);
	  }

	// --- True URI:  unc:myfile.txt
	return new Uri (filenameOrUri);
      }

    // --- finally, it has no colon, so is either a relative URI or a
    //   - pathname.  If we're in this method, we assume that it is a
    //   - pathname.
    return resolveFilenameToUri (filenameOrUri);
  }

@SuppressWarnings("deprecation")
public static Uri resolveFilenameToUri (String filename)
    throws MalformedUriException
  {
    // XXX relative links go away here, and shouldn't... <sigh>...

    // XXX this is probably broken in so many ways.

//     return new Uri ("file", null, filename);

    URL url;
    try {
      url = new File (filename).toURL ();
    } catch (MalformedURLException ex) {
      throw new MalformedUriException
	("Error converting File object "+filename+" to URI", ex);
    }
    Uri uri = new Uri (url);
//     if (uri.getAuthority () == null)
//       return uri.replaceAuthority ("");
    return uri;
  }

  // -------------------------------------------------------------------------
  // ---- Exception Definitions ----------------------------------------------
  // -------------------------------------------------------------------------

  public static class MalformedUriException extends RuntimeException
  {
    private static final long serialVersionUID = 1L;
    public MalformedUriException () { super (); }
    public MalformedUriException (String msg) { super (msg); }
    public MalformedUriException (String msg, Throwable ex) { super (msg,ex); }
  }

  public static class UpdirPastRootException extends MalformedUriException
  {
    private static final long serialVersionUID = 1L;
    public UpdirPastRootException () { super (); }
    public UpdirPastRootException (String msg) { super (msg); }
    public UpdirPastRootException (String msg,Throwable ex) { super (msg,ex); }
  }

  // -------------------------------------------------------------------------
  // ---- URI Parser ---------------------------------------------------------
  // -------------------------------------------------------------------------


  private static class UriParser {
    char[] chars;
    int pos;

    public UriParser (String uri)
    {
      chars = uri.toCharArray ();
      pos = 0;
    }

    String consumeScheme ()
    {
      int start = pos;
      int end = pos;
      boolean done = false;
      boolean sawColon = false;
      while (!done)
	{
	  if (end >= chars.length) done = true;
	  else
	    {
	      char c = chars[end];
	      if (c == '/') done = true;
	      else if (c == '?') done = true;
	      else if (c == '#') done = true;
	      else if (c == ':') 
		{
		  done = true;
		  sawColon = true;
		}
	      else
		end++;
	    }
	}

      if (sawColon)
	{
	  String scheme = new String (chars, start, end-start);
	  pos = end+1;
	  return scheme;
	}

      return null;
    }

    String consumeAuthority ()
    {
      int start = pos;
      int end = pos;

      // --- here we are...
      if (end + 1 >= chars.length) return null;
      if (chars[end] == '/' && chars[end+1] == '/')
	{
	  start += 2;
	  end += 2;
	  
	  boolean done = false;
	  while (!done)
	    {
	      if (end >= chars.length) done = true;
	      else
		{
		  char c = chars[end];
		  if (c == '/') done = true;
		  else if (c == '?') done = true;
		  else if (c == '#') done = true;
		  else end++;
		}
	    }
	  
	  String authority = new String (chars, start, end-start);
	  pos = end;
	  return authority;
	}

      return null;
    }

    String consumePath ()
    {
      int start = pos;
      int end = pos;

      boolean done = false;
      while (!done)
	{
	  if (end >= chars.length) done = true;
	  else
	    {
	      char c = chars[end];
	      if (c == '?') done = true;
	      else if (c == '#') done = true;
	      else end++;
	    }
	}

      String path = new String (chars, start, end-start);
      pos = end;
      return path;
    }

    String consumeQuery ()
    {
      int start = pos;
      int end = pos;

      // --- here we are...
      if (end >= chars.length) return null;
      if (chars[end] == '?')
	{
	  start += 1;
	  end += 1;
	  
	  boolean done = false;
	  while (!done)
	    {
	      if (end >= chars.length) done = true;
	      else
		{
		  char c = chars[end];
		  if (c == '#') done = true;
		  else end++;
		}
	    }
	  
	  String query = new String (chars, start, end-start);
	  pos = end;
	  return query;
	}

      return null;
    }

    String consumeFragment ()
    {
      int start = pos;
      int end = pos;

      // --- here we are...
      if (end >= chars.length) return null;
      if (chars[end] == '#')
	{
	  start += 1;
	  end += 1;
	  
	  boolean done = false;
	  while (!done)
	    {
	      if (end >= chars.length) done = true;
	      else
		{
		  //char c = chars[end];
		  end++;
		}
	    }
	  
	  String query = new String (chars, start, end-start);
	  pos = end;
	  return query;
	}

      return null;
    }
  }

  // -------------------------------------------------------------------------
  // ---- Utility Methods ----------------------------------------------------
  // -------------------------------------------------------------------------

  public static Uri validateEmail (String email) throws MalformedUriException
  {
    int atIndex = email.indexOf ('@');
    if (atIndex == -1)
      throw new MalformedUriException
	("Bad email address '"+email+"': does not contain '@'");

    String user = email.substring (0, atIndex);
    String domain = email.substring (atIndex+1);

    // for the exception
    try {
      return new Uri ("mailto:"+user+"@"+domain);
    } catch (MalformedUriException ex) {
      throw new MalformedUriException ("Bad email address '"+email+"': "+
				       ex.getMessage (), ex);
    }
  }

  public static Uri validateWww (String www) throws MalformedUriException
  {
    if (!www.startsWith ("http://"))
      www = "http://"+www;

    // for the exception
    try {
      return new Uri (www);
    } catch (MalformedUriException ex) {
      throw new MalformedUriException ("Bad www address '"+www+"': "+
				       ex.getMessage (), ex);
    }
  }

  // -------------------------------------------------------------------------
  // ---- Test Code ----------------------------------------------------------
  // -------------------------------------------------------------------------

//   public static void main (String[] args) throws Exception
//   {
//     testURL (args);
//   }

//   public static void testURL (String[] args)
//     throws Exception
//   {
//     Uri uri = new Uri (new URL ("http://www.svincent.com/?hello-there"));
//     uri.dump (Util.debug);
//   }

//   public static void testMisc (String[] args)
//     throws MalformedUriException
//   {
//     Uri jarFile = new Uri ("jar:file:myfile.jar!/foo/file.txt");
//     jarFile.dump (Util.debug);
//   }

//   public static void testCalculateRelative (String[] args)
//     throws MalformedUriException
//   {
//     Uri from = new Uri (args[0]);
//     Uri to = new Uri (args[1]);

//     Util.out.println ("relative == "+Uri.calculateRelativeUri (from, to));
//   }

//   public static void testPaths (String[] args) throws MalformedUriException
//   {
//     ParsedPath path = new ParsedPath ();
//     for (int i=0; i<args.length; i++)
//       {
// 	path.apply (args[i], true);
// 	Util.out.println (path);
//       }
//     Util.out.println (path);
//   }

// //   public static void interactive (String[] args) throws MalformedUriException
// //   {
// //     OptParser optParser = new OptParser ().startClass (Uri.class);
// //     StringOpt baseOpt = optParser.opt ().
// //       longName ("base").shortName ('b').
// //       description ("Base URI").
// //       asString ();
// //     StringOpt uriOpt = optParser.opt ().
// //       longName ("uri").shortName ('u').nameless ().
// //       required ().description ("Uniform Resource Identifier").
// //       asString ();
// //     OptResult optResult = optParser.run (args);
// //     String baseUriStr = baseOpt.getString (optResult);
// //     String uriStr = uriOpt.getString (optResult);

// //     Uri baseUri = null;
// //     if (baseUriStr != null) baseUri = new Uri (baseUriStr);
// //     Uri uri = new Uri (uriStr);

// //     if (baseUri != null)
// //       {
// // 	Util.out.println ("Base URI:");
// // 	baseUri.dump (Util.debug);
// // 	Util.out.println (baseUri.asString ());
// //       }

// //     Util.out.println ("Relative URI:");
// //     uri.dump (Util.debug);
// //     Util.out.println (uri.asString ());

// //     if (baseUri != null)
// //       {
// // 	Uri resolved = resolveRelativeUri (baseUri, uri);

// // 	Util.out.println ("Resolved URI:");
// // 	resolved.dump (Util.debug);
// // 	Util.out.println (resolved.asString ());
// //       }
// //   }

//   public static void test1 (String[] args) throws MalformedUriException
//   {
//     String base = "http://a/b/c/d;p?q";
//     testCase (base, "g:h", "g:h");
//     testCase (base, "g", "http://a/b/c/g");
//     testCase (base, "./g", "http://a/b/c/g");
//     testCase (base, "g/", "http://a/b/c/g/");
//     testCase (base, "/g", "http://a/g");
//     testCase (base, "//g", "http://g");
//     testCase (base, "?y", "http://a/b/c/?y");
//     testCase (base, "g?y", "http://a/b/c/g?y");
//     testCase (base, "#s", "http://a/b/c/d;p?q#s");
//     testCase (base, "g#s", "http://a/b/c/g#s");
//     testCase (base, "g?y#s", "http://a/b/c/g?y#s");
//     testCase (base, ";x", "http://a/b/c/;x");
//     testCase (base, "g;x", "http://a/b/c/g;x");
//     testCase (base, "g;x?y#s", "http://a/b/c/g;x?y#s");
//     testCase (base, ".", "http://a/b/c/");
//     testCase (base, "./", "http://a/b/c/");
//     testCase (base, "..", "http://a/b/");
//     testCase (base, "../", "http://a/b/");
//     testCase (base, "../g", "http://a/b/g");
//     testCase (base, "../..", "http://a/");
//     testCase (base, "../../", "http://a/");
//     testCase (base, "../../g", "http://a/g");


//     testCase (base, "", "http://a/b/c/d;p?q");

//     testCase (base, "/./g", "http://a/./g");
//     testCase (base, "/../g", "http://a/../g");
//     testCase (base, "g.", "http://a/b/c/g.");
//     testCase (base, ".g", "http://a/b/c/.g");
//     testCase (base, "g..", "http://a/b/c/g..");
//     testCase (base, "..g", "http://a/b/c/..g");

//     testCase (base, "./../g", "http://a/b/g");
//     testCase (base, "./g/.", "http://a/b/c/g/");
//     testCase (base, "g/./h", "http://a/b/c/g/h");
//     testCase (base, "g/../h", "http://a/b/c/h");
//     testCase (base, "g;x=1/./y", "http://a/b/c/g;x=1/y");
//     testCase (base, "g;x=1/../y", "http://a/b/c/y");

//     testCase (base, "g?y/./x", "http://a/b/c/g?y/./x");
//     testCase (base, "g?y/../x", "http://a/b/c/g?y/../x");
//     testCase (base, "g#s/./x", "http://a/b/c/g#s/./x");
//     testCase (base, "g#s/../x", "http://a/b/c/g#s/../x");

//     testCase (base, "http:g", "http:g");
//   }

//   public static void testCase (String baseStr, String relativeStr, 
// 			       String desired)
//     throws MalformedUriException
//   {
//     Uri base = new Uri (baseStr);
//     Uri relative = new Uri (relativeStr);

//     Uri resolved = Uri.resolveRelativeUri (base, relative);
//     if (!resolved.toString ().equals (desired))
//       {
// 	Util.out.println ();
// 	Util.out.println ("Unexpected URI came out!");
// 	Util.out.println ("Base URI: "+base);
// 	base.dump (Util.debug);

// 	Util.out.println ("Relative URI: "+relative);
// 	relative.dump (Util.debug);

// 	Util.out.println ("Resolved URI: "+resolved);
// 	resolved.dump (Util.debug);

// 	Util.out.println ("Desired resolved URI: "+desired);
//       }
//     else
//       {
// 	Util.out.println (baseStr+" + "+relativeStr+" = "+
// 			  resolved.toString ()+": OK");
//       }
//   }


}
