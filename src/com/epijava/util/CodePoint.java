/*
 * 
 */
package com.epijava.util;

/**
 * Represents a Unicode code point.
 * 
 * <p>
 * Kindof like a Character, but represents an arbitrary 32-bit representation of
 * a Unicode code point, rather than a 16-bit portion of a UTF-16 encoded
 * Unicode string.
 * 
 */
public final class CodePoint extends Number implements Comparable<CodePoint> {

    private static final long serialVersionUID = 1L;
    
    private final int codePoint;
    
    // a flyweight cache for normal ASCII characters + 128 extras....
    private static final int CacheSize = 256;
    private static final CodePoint[] Cache;
    static {
        Cache = new CodePoint[CacheSize];
        for (int i=0; i<CacheSize; i++)
            Cache[i] = new CodePoint(i);
    }
    
    private CodePoint(int _codePoint) {
        if (_codePoint < 0)
            throw new IllegalArgumentException(
                    "Negative code points are illegal: " + _codePoint);
        codePoint = _codePoint;
    }
    
    private CodePoint(char c) {
        this((int) c);
        if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c))
            throw new IllegalArgumentException(
                    "Character "
                            + Integer.toHexString(c)
                            + " is not a valid Unicode character (it is part of a surrogate pair instead)");
    }

    public static CodePoint valueOf(char v) {
        if (v < CacheSize)
            return Cache[v];
        return new CodePoint(v);
    }

    public static CodePoint valueOf(int v) {
        if (v >=0 && v < CacheSize)
            return Cache[v];
        return new CodePoint(v);
    }

    @Override
    public int intValue() {
        return codePoint;
    }

    @Override
    public double doubleValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public long longValue() {
        return intValue();
    }
    
    public char[] toChars() {
        return Character.toChars(codePoint);
    }
    
    public int toChars(char[] dst, int dstIndex) {
        return Character.toChars(codePoint, dst, dstIndex);
    }
    
    @Override
    public int hashCode() { return codePoint; }
    
    @Override
    public boolean equals(Object _that) {
        if (!(_that instanceof CodePoint))
            return false;
        
        CodePoint that = (CodePoint)_that;
        return this.codePoint == that.codePoint;
    }
    
    public int compareTo(CodePoint that) {
        return this.codePoint - that.codePoint;
    }

    @Override    
    public String toString() {
        return new String(toChars());
    }

    public boolean isWhitespace() {
        return Character.isWhitespace(codePoint);
    }

}
