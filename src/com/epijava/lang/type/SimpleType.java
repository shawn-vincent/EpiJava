/*
 * 
 */
package com.epijava.lang.type;

import java.util.*;

import com.epijava.lang.reflect.*;

/**
 * A Type object that represents a Java reference or primitive type.
 * 
 * <p>
 * Subclasses of this class represent primitive types and the Java language NULL
 * type.
 */
public class SimpleType<T> extends Type {

    /**
     * Cache of ClassTypes by Class - memory leak bounded by # of classes in VM.
     */
    private static Map<Class<?>, SimpleType<?>> ClassTypesByClass = new HashMap<Class<?>, SimpleType<?>>();

    /**
     * Note: can be null, if this is an instance of NullType
     */
    private final Class<T> clazz;

    /**
     * Cached calculation of whether this class represents a primitive wrapper.
     */
    private boolean calculatedIsPrimitiveWrapper = false;
    private boolean isPrimitiveWrapper;

    /**
     * Cached calculation of isMethodParmAssignableFrom
     */
//    private Map<SimpleType<?>, Boolean> cachedIsMethodParmAssignableFrom = new HashMap<SimpleType<?>, Boolean>();

    private final int cachedHashCode;

    /**
     * Protected constructor: use {@link #make(Class)} instead.
     */
    protected SimpleType(Class<T> _clazz) {
        clazz = _clazz;

        if (clazz == null && !(this instanceof NullType))
            throw new NullPointerException(
                    "Cannot create ClassType with a NULL class "
                            + "unless you are constructing a NullType");

        cachedHashCode = _clazz == null ? 42 : _clazz.hashCode();
    }

    /**
     * Make an appropriate ClassType for a given clazz.
     * 
     * <p>
     * May return an object from a pool for commonly used objects.
     * 
     * XXX not thread safe!
     */
    @SuppressWarnings("unchecked")
    public static <T> SimpleType<T> make(Class<T> clazz) {
        // fetch all from pool.
        // XXX not thread safe!
        SimpleType<T> r = (SimpleType<T>) ClassTypesByClass.get(clazz);
        if (r == null) {
            r = makeUncached(clazz);
            ClassTypesByClass.put(clazz, r);
        }
        return r;
    }

    private static <T> SimpleType<T> makeUncached(Class<T> clazz) {
        if (clazz == null)
            return new NullType<T>();

        if (clazz.isPrimitive())
            return new PrimitiveType<T>(clazz);

        return new SimpleType<T>(clazz);
    }

    /**
     * Convenience method: Make ClassTypes for an array of Classes.
     */
    public static SimpleType<?>[] make(Class<?>[] types) {
        SimpleType<?>[] r = new SimpleType[types.length];
        for (int i = 0; i < types.length; i++)
            r[i] = make(types[i]);
        return r;
    }

    /**
     * Fetch the ClassType representing the type of the given Java Object.
     * 
     * <p>
     * Returns an instance of NullType if the object reference is NULL.
     */
    @SuppressWarnings("unchecked")
    public static <T> SimpleType<T> getClass(T obj) {
        if (obj == null)
            return new NullType<T>();
        return make((Class<T>) obj.getClass());
    }

    /**
     * Convenience method: Fetch the ClassTypes for each object in an array.
     */
    public static SimpleType<?>[] getClasses(Object[] objs) {
        SimpleType<?>[] r = new SimpleType[objs.length];
        for (int i = 0; i < objs.length; i++)
            r[i] = getClass(objs[i]);
        return r;
    }

    /**
     * Fetch the String name corresponding to this Class object.
     */
    public JavaName<Type> getName() {
        if (clazz == null)
            return JavaName.type("<NULL type>");

        return JavaName.type(clazz.getName());
    }

    /**
     * Return the underlying java.lang.Class representing this Type.
     * 
     * <p>
     * Can return NULL if this is an instance of NullType.
     */
    public Class<T> getJavaClass() {
        return clazz;
    }

    /**
     * Return TRUE iff this class represents a primitive type (int, long, etc)
     * 
     * <p>
     * If TRUE, this will be an instanceof {@link PrimitiveType}
     */
    public boolean isPrimitive() {
        return false;
    }
    
    public boolean isReference() {
        return !isPrimitive();
    }

    /**
     * Return TRUE iff this class is one of the standard primitive wrapper types
     * (Integer, Long, etc)
     */
    public boolean isPrimitiveWrapper() {

        if (!calculatedIsPrimitiveWrapper) {
            isPrimitiveWrapper = PrimitiveType.getUnboxedType(this) != null;
            calculatedIsPrimitiveWrapper = true;
        }
        return isPrimitiveWrapper;
    }

    /**
     * Return the boxed version of this type.
     * 
     * <p>
     * For a primitive type, will return the primitive wrapper type
     * corresponding to that primitive.
     * 
     * <p>
     * For normal Object types, will return this.
     */
    public SimpleType<?> box() {
        return this;
    }

    /**
     * Return the unboxed version of this type, or NULL if no such unboxed
     * version exists.
     * 
     * <p>
     * For primitive wrapper types, returns the corresponding primmitive type.
     * 
     * <p>
     * For all other types, returns NULL.
     */
    public SimpleType<?> unbox() {
        return PrimitiveType.getUnboxedType(this);
    }

    /**
     * Return true if any instance of 'that' class can be assigned to 'this'
     * class.
     * 
     * <p>
     * For null types, any NULL type is assignable to any other type. No
     * non-NULL type is assignable to a NULL type
     * 
     * <p>
     * For other types, this method has the same semantics as
     * {@link Class#isAssignableFrom(Class)}
     */
    private boolean isAssignableFrom(SimpleType<?> that) {
        // NULL type is not assignable from any non-null type
        if (clazz == null && that.clazz != null)
            return false;

        // NULL type is assignable TO any type
        if (that.clazz == null)
            return true;

        return clazz.isAssignableFrom(that.clazz);
    }

    /**
     * Return true if any instance of 'argType' is assignable to this type in a
     * Java method call, if this type is the parameter type.
     * 
     * <p>
     * For primitive types, this method supports autoboxing and unboxing, as
     * well as primitive coercion
     * 
     * <p>
     * Also supports NULL types appropriately.
     */
    public boolean isMethodParmAssignableFrom(SimpleType<?> argType,
            boolean allowBoxing) {
        // XXX re-enable this cache at some point, but it has to include
        // 'allowBoxing'
        // Boolean _r = cachedIsMethodParmAssignableFrom.get(argType);
        // if (_r != null)
        // return _r;

        boolean r = isMethodParmAssignableFromUncached(argType, allowBoxing);
        // cachedIsMethodParmAssignableFrom.put(argType, r);
        return r;
    }

    protected boolean isMethodParmAssignableFromUncached(SimpleType<?> argType,
            boolean allowBoxing) {

        if (argType == null)
            return true;

        if (allowBoxing && argType.isPrimitive())
            argType = argType.box();

        if (isAssignableFrom(argType))
            return true;

        return false;
    }
    
    public <D extends Definition> D getDefinition(JavaName<D> name) {
        // overridden in NullType: don't need to check for null here.
        if (name.isTypeName()) {
            Class<?>[] allClasses = clazz.getDeclaredClasses();
            for (Class<?> c : allClasses)
                if (c.getName().equals(name))
                    return name.cast(SimpleType.make(c));
            return null;
            
        } else if (name.isFunctionName()) {
            throw new UnsupportedOperationException();

        } else if (name.isVarName()) {
            throw new UnsupportedOperationException();

        } else if (name.isPackageName()) {
            return null;
            
        } else {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "type " + getName().getName();
    }

    public int hashCode() {
        return cachedHashCode;
    }

    public boolean equals(Object _that) {
        if (!(_that instanceof SimpleType))
            return false;
        SimpleType<?> that = (SimpleType<?>) _that;
        return this.clazz == that.clazz;
    }

    public static String toString(Collection<SimpleType<?>> argTypes) {
        return toString(argTypes.toArray(new SimpleType<?>[argTypes.size()]));
    }

    public static String toString(SimpleType<?>[] argTypes) {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < argTypes.length; i++) {
            if (i > 0)
                r.append(", ");

            r.append(argTypes[i].getName().getName());
        }

        return r.toString();
    }

    public static Type forName(String typeName) {
        
        if (typeName.endsWith("]"))
            throw new UnsupportedOperationException("Array types not yet supported!");
        
        switch(typeName.charAt(0)) {
        case 'd':
            if (typeName.equals("double"))
                return PrimitiveType.Double;
            break;
        case 'f':
            if (typeName.equals("float"))
                return PrimitiveType.Float;
            break;
        case 'l':
            if (typeName.equals("long"))
                return PrimitiveType.Long;
            break;
        case 'i':
            if (typeName.equals("int"))
                return PrimitiveType.Int;
            break;
        case 's':
            if (typeName.equals("short"))
                return PrimitiveType.Short;
            break;
        case 'c':
            if (typeName.equals("char"))
                return PrimitiveType.Char;
            break;
        case 'b':
            if (typeName.equals("boolean"))
                return PrimitiveType.Boolean;
            if (typeName.equals("byte"))
                return PrimitiveType.Byte;
            break;
        case 'v':
            if (typeName.equals("void"))
                return PrimitiveType.Void;
            break;
        }
        
        try {
            return SimpleType.make(Class.forName(typeName));
        } catch (ClassNotFoundException ex) {
            throw new NotFoundReflectException("Could not find type "+typeName, ex);
        }
    }
}
