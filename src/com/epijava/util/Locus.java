/*
 *
 *
 */
package com.epijava.util;

public interface Locus {

    public final Locus Unknown = new ConstantLocus(null, -1, -1);

    public String locusModule();
    public int locusPosition();

    public static class ConstantLocus implements Locus {
	private final String locusModule;
	private final int locusPosition;
	private final int locusColumn;

	public ConstantLocus(String _locusModule, int _locusPosition) {
	    this(_locusModule, _locusPosition, -1);
	}

	public ConstantLocus(String _locusModule, int _locusPosition, int _locusColumn)
	{ locusModule = _locusModule; locusPosition = _locusPosition; locusColumn = _locusColumn; }

	public String locusModule() { return locusModule; }
	public int locusPosition() { return locusPosition; }
	public int locusColumn() { return locusColumn; }
	
	public String toString() {
	    return locusModule + ":" + locusPosition + ":" + locusColumn;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + locusColumn;
	    result = prime * result
	    + ((locusModule == null) ? 0 : locusModule.hashCode());
	    result = prime * result + locusPosition;
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    final ConstantLocus other = (ConstantLocus) obj;
	    if (locusColumn != other.locusColumn)
	        return false;
	    if (locusModule == null) {
	        if (other.locusModule != null)
	            return false;
	    } else if (!locusModule.equals(other.locusModule))
	        return false;
	    if (locusPosition != other.locusPosition)
	        return false;
	    return true;
	}

    }
}