/*
 * 
 */
package com.epijava.lang.type;

import java.io.*;

public class SourceFile {
    private final String locusModule;
    private final Reader reader;
    
    public SourceFile(String _locusModule, Reader _reader) {
        locusModule = _locusModule;
        reader = _reader;
    }

    public String getLocusModule() {
        return locusModule;
    }

    public Reader getReader() {
        return reader;
    }
}