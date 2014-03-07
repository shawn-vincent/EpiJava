/*
 *
 *
 */
package com.epijava.launch;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.text.*;
import java.util.*; 
import org.slf4j.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.*; 

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;

import com.epijava.web.*;

/**
 * Main JNLP entry point to launch the EpiJava system.
 **/
public class EpiLaunch {

    // "EpiJava Development Environment" totals (numerologically) to
    // 137.  So we claim 8137 for EpiJava.xs!
    private static final int PortNumber = 8137;

    private final static Logger logger = LoggerFactory.getLogger(EpiLaunch.class);

    public static void main(String[] args) throws Exception {

	logger.info("EpiJava launched at "+new SimpleDateFormat("MMM d yy h:mm a").format(new Date()));

	try {
	    sendHttpRequest("http://localhost:"+PortNumber+"/quit", null);
	} catch (ConnectException ex) {
	    logger.debug("No previous instance of Epijava to shut down");
	} catch (IOException ex) {
	    logger.warn("Got unexpected error when trying to shut down previous instance of EpiJava", ex);
	}

	final WebRoot webRoot = new ExampleWebRoot(); 

	Handler handler=new AbstractHandler()
	    {
		public void handle(String target, Request jettyRequest, HttpServletRequest request,
				   HttpServletResponse response)
		    throws IOException, ServletException
		{
		    String requestedPath = getRequestedPath(request);
		    logger.info("incoming request: "+requestedPath);

		    try {
			Object r = webRoot.getUriHandler().handleUri(requestedPath);

			// XXX convert r into a web response generically somehow.

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println(r);
			((Request)request).setHandled(true);

		    } catch (Throwable ex) {
			// XXX build a proper error response with a nice rendering of the error.
			logger.error("Bad things happen to good people", ex);

			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			PrintWriter out = response.getWriter();

			out.println("<pre>");
			ex.printStackTrace(out);
			out.println("</pre>");

			((Request)request).setHandled(true);
		    }
		}
	    };

	
	Server server = new Server(PortNumber);
	server.setHandler(handler);
	try {
	    server.start();
	} catch (BindException ex) {
	    throw new RuntimeException("Unable to start EpiJava server: perhaps another server is already running on port "+PortNumber, ex);
	}
	
	launchBrowserWithHomePage();

	// stall thread.
	server.join();
    }

    private static String getRequestedPath(HttpServletRequest request) {
	String r = request.getRequestURI();
	if (request.getQueryString() != null)
	    r += "?" + request.getQueryString();
	return r.toString();
    }


    public static class ExampleWebRoot extends WebRoot {

	public String hello() {
	    return "Hello";
	}

	public ExampleWebDir dir() {
	    return new ExampleWebDir();
	}

	public Filesystem fs() {
	    return new Filesystem();
	}

	public int answer() {
	    return 42;
	}

    }

    public static class ExampleWebDir {

	public String foo() {
	    return "WebDir -> foo!";
	}

	public String toString() {
	    return "This is a web dir -- maybe contents could be listed here somehow...";
	}
    }

    public static class Filesystem implements UriHandler {
	public Object handleUri(String uri) {
	    return "Handling URI: "+uri;
	}
    }

    private static String sendHttpRequest(String url, String body) throws Exception {
	HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();;
	try {
	    conn.setRequestMethod("GET");
	    conn.setDoOutput(true);
	    conn.setReadTimeout(10000);
	    conn.connect();
	    
	    if (body != null) {
		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
		try {
		    out.write(body);
		    out.flush();
		} finally {
		    out.close();
		}
	    }
	    
	    //read the result from the server
	    StringBuilder r = new StringBuilder();
	    BufferedReader in = 
		new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    try {
		
		String line;
		while ((line = in.readLine()) != null)
		    r.append(line + '\n');
		
	    } finally {
		in.close();
	    }
	    
	    return r.toString();
	    
	} catch (MalformedURLException ex) {
	    throw (IOException)new IOException("Bad URL: "+url).initCause(ex);
	} catch (ProtocolException ex) {
	    throw (IOException)new IOException("Protocol exception").initCause(ex);
	} finally {
	    conn.disconnect();
	}
    }


    private static void launchBrowserWithHomePage() throws Exception {
	launchBrowser("http://localhost:"+PortNumber+"/");
    }


    /////////////////////////////////////////////////////////
    //  Bare Bones Browser Launch                          //
    //  Version 2.0 (May 26, 2009)                         //
    //  By Dem Pilafian                                    //
    //  Supports:                                          //
    //     Mac OS X, GNU/Linux, Unix, Windows XP/Vista     //
    //  Public Domain Software -- Free to Use as You Like  //
    /////////////////////////////////////////////////////////

    static final String[] browsers = { 
	"www-browser", // debian update-alternatives target
	"firefox", "opera", "konqueror", "epiphany", 
	"seamonkey", "galeon", "kazehakase", "mozilla",
	"netscape" , "w3m", "lynx" };

    public static void launchBrowser(String url) { 
	String osName = System.getProperty("os.name");
	try {
	    if (osName.startsWith("Mac OS")) {
		Class<?> fileMgr = Class.forName("com.apple.eio.FileManager");
		Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] {String.class}); 
		openURL.invoke(null, new Object[] {url});
	    } else if (osName.startsWith("Windows")) {
		Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url); 
	    } else { 
		// assume Unix or Linux
		boolean found = false;
		for (String browser : browsers)
		    if (!found) {
			found = Runtime.getRuntime().exec( new String[] {"which", browser})
			    .waitFor() == 0;

			if (found)
			    Runtime.getRuntime().exec(new String[] {browser, url});
		    }
		if (!found)
		    throw new Exception(Arrays.toString(browsers));
	    }
	} catch (final Exception ex) { 
	    ex.printStackTrace();
	    SwingUtilities.invokeLater(new Runnable () {
		    public void run() {
			JOptionPane.showMessageDialog
			    (null, "Error attempting to launch web browser:\n" + ex.toString());
		    }
		});
	}
    } 

}