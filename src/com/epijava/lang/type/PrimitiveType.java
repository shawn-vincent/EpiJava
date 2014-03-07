/*
 * 
 */
package com.epijava.lang.type;

import java.util.*;

/**
 * Subclass of ClassType that represents Java primitive types.
 */
public class PrimitiveType<T> extends SimpleType<T> {

    /**
     * An enum corresponding to the primitive type: helpful for switch
     * statements
     */
    private final PrimitiveTypeEnum primitiveTypeEnum;

    /**
     * The precalculated wrapper (boxed) type for this primitive
     */
    private final SimpleType<?> wrapperType;

    /**
     * Make a new primitive type for a class object.
     */
    protected PrimitiveType(Class<T> clazz) {
        super(clazz);

        if (clazz == null)
            throw new NullPointerException(
                    "Cannot create primitive type with NULL Class");

        if (!clazz.isPrimitive())
            throw new IllegalArgumentException(
                    "Cannot create primitive type with non-primitive Class "
                            + clazz.getName());

        primitiveTypeEnum = classToPrimitiveType.get(clazz);
        wrapperType = SimpleType.make(primitiveTypeToAutoboxedType.get(clazz));

        if (primitiveTypeEnum == null)
            throw new AssertionError(
                    "Got NULL primitiveTypeEnum for primitive type "
                            + getName());

        if (wrapperType == null)
            throw new AssertionError("Got NULL wrapperType for primitive type "
                    + getName());
    }

    public static <T> PrimitiveType<T> make(Class<T> clazz) {
        return (PrimitiveType<T>) SimpleType.make(clazz);
    }

    public boolean isPrimitive() {
        return true;
    }

    public SimpleType<?> box() {
        return wrapperType;
    }
    
    public <D extends Definition> D getDefinition(JavaName<D> name) {
        return null;
    }

    @Override
    protected boolean isMethodParmAssignableFromUncached(SimpleType<?> argType, boolean allowBoxing) {

        // autounboxing
        // demote to primitive type so the next branch will catch it.
        if (allowBoxing && argType.isPrimitiveWrapper())
            argType = argType.unbox();

        // only primitives (or unboxed wrappers) are allowed
        if (!argType.isPrimitive())
            return false;

        // fetch the two enums, for efficiency in the next section.
        PrimitiveTypeEnum toType = this.primitiveTypeEnum;
        PrimitiveTypeEnum fromType = ((PrimitiveType<?>) argType).primitiveTypeEnum;

        /*
         * JLS 3rd edition - 5.1.2 states:
         * 
         * The following 19 specific conversions on primitive types are called
         * the widening primitive conversions:
         * 
         * byte to short, int, long, float, or double
         * 
         * short to int, long, float, or double
         * 
         * char to int, long, float, or double
         * 
         * int to long, float, or double
         * 
         * long to float or double
         * 
         * float to double
         */

        switch (fromType) {

        case booleanType:
        case voidType:
        case doubleType:
            // cannot widen boolean, void, or double.
            return fromType == toType;

        case floatType:
            // float to double
            switch (toType) {
            case doubleType:
            case floatType:
                return true;
            default:
                return false;
            }

        case longType:
            // long to float or double
            switch (toType) {
            case doubleType:
            case floatType:
            case longType:
                return true;

            default:
                return false;
            }

        case intType:
            // int to long, float or double
            switch (toType) {
            case doubleType:
            case floatType:
            case longType:
            case intType:
                return true;

            default:
                return false;
            }

        case charType:
            // char to int, long, float, or double
            switch (toType) {
            case intType:
            case longType:
            case floatType:
            case doubleType:
            case charType:
                return true;

            default:
                return false;
            }

        case shortType:
            // short to int, long, float, or double
            switch (toType) {
            case intType:
            case longType:
            case floatType:
            case doubleType:
            case shortType:
                return true;

            default:
                return false;
            }

        case byteType:
            // byte to short, int, long, float, or double
            switch (toType) {
            case shortType:
            case intType:
            case longType:
            case floatType:
            case doubleType:
            case byteType:
                return true;

            default:
                return false;
            }

        default:
            throw new AssertionError("Unknown primitive type: " + fromType);
        }
    }

    static SimpleType<?> getUnboxedType(SimpleType<?> boxedType) {
        return PrimitiveType.AutoboxedTypeToPrimitiveType.get(boxedType);
    }

    private static Map<Class<?>, Class<?>> primitiveTypeToAutoboxedType = new HashMap<Class<?>, Class<?>>();
    private static Map<Class<?>, PrimitiveTypeEnum> classToPrimitiveType = new HashMap<Class<?>, PrimitiveTypeEnum>();
    static {
        primitiveTypeToAutoboxedType.put(void.class, Void.class);
        primitiveTypeToAutoboxedType.put(boolean.class, Boolean.class);
        primitiveTypeToAutoboxedType.put(byte.class, Byte.class);
        primitiveTypeToAutoboxedType.put(char.class, Character.class);
        primitiveTypeToAutoboxedType.put(short.class, Short.class);
        primitiveTypeToAutoboxedType.put(int.class, Integer.class);
        primitiveTypeToAutoboxedType.put(long.class, Long.class);
        primitiveTypeToAutoboxedType.put(float.class, Float.class);
        primitiveTypeToAutoboxedType.put(double.class, Double.class);

        classToPrimitiveType.put(void.class, PrimitiveTypeEnum.voidType);
        classToPrimitiveType.put(boolean.class, PrimitiveTypeEnum.booleanType);
        classToPrimitiveType.put(byte.class, PrimitiveTypeEnum.byteType);
        classToPrimitiveType.put(char.class, PrimitiveTypeEnum.charType);
        classToPrimitiveType.put(short.class, PrimitiveTypeEnum.shortType);
        classToPrimitiveType.put(int.class, PrimitiveTypeEnum.intType);
        classToPrimitiveType.put(long.class, PrimitiveTypeEnum.longType);
        classToPrimitiveType.put(float.class, PrimitiveTypeEnum.floatType);
        classToPrimitiveType.put(double.class, PrimitiveTypeEnum.doubleType);
    }

    public enum PrimitiveTypeEnum {
        doubleType, floatType, longType, intType, shortType, charType, byteType, booleanType, voidType;
    }

    // constants for primitive types
    public static final PrimitiveType<Double> Double = PrimitiveType
            .make(double.class);
    public static final PrimitiveType<Float> Float = PrimitiveType
            .make(float.class);
    public static final PrimitiveType<Long> Long = PrimitiveType
            .make(long.class);
    public static final PrimitiveType<Integer> Int = PrimitiveType
            .make(int.class);
    public static final PrimitiveType<Short> Short = PrimitiveType
            .make(short.class);
    public static final PrimitiveType<Character> Char = PrimitiveType
            .make(char.class);
    public static final PrimitiveType<Byte> Byte = PrimitiveType
            .make(byte.class);
    public static final PrimitiveType<Boolean> Boolean = PrimitiveType
            .make(boolean.class);
    public static final PrimitiveType<Void> Void = PrimitiveType
            .make(void.class);

    // constants for standard wrapper types
    public static final SimpleType<Double> DoubleWrapper = SimpleType
            .make(Double.class);
    public static final SimpleType<Float> FloatWrapper = SimpleType
            .make(Float.class);
    public static final SimpleType<Long> LongWrapper = SimpleType
            .make(Long.class);
    public static final SimpleType<Integer> IntWrapper = SimpleType
            .make(Integer.class);
    public static final SimpleType<Short> ShortWrapper = SimpleType
            .make(Short.class);
    public static final SimpleType<Character> CharWrapper = SimpleType
            .make(Character.class);
    public static final SimpleType<Byte> ByteWrapper = SimpleType
            .make(Byte.class);
    public static final SimpleType<Boolean> BooleanWrapper = SimpleType
            .make(Boolean.class);
    public static final SimpleType<Void> VoidWrapper = SimpleType
            .make(Void.class);

    /**
     * Internal data structures used to determine whether this class is an
     * autoboxed type, and what primitive type corresponds to it.
     */
    protected static final Map<SimpleType<?>, PrimitiveType<?>> AutoboxedTypeToPrimitiveType = new HashMap<SimpleType<?>, PrimitiveType<?>>();

    static {
        AutoboxedTypeToPrimitiveType.put(VoidWrapper, Void);
        AutoboxedTypeToPrimitiveType.put(BooleanWrapper, Boolean);
        AutoboxedTypeToPrimitiveType.put(ByteWrapper, Byte);
        AutoboxedTypeToPrimitiveType.put(CharWrapper, Char);
        AutoboxedTypeToPrimitiveType.put(ShortWrapper, Short);
        AutoboxedTypeToPrimitiveType.put(IntWrapper, Int);
        AutoboxedTypeToPrimitiveType.put(LongWrapper, Long);
        AutoboxedTypeToPrimitiveType.put(FloatWrapper, Float);
        AutoboxedTypeToPrimitiveType.put(DoubleWrapper, Double);
    }

}
