/*
 * 
 */
package com.epijava.lang.reflect;

import java.lang.reflect.*;
import java.util.*;

import com.epijava.lang.type.*;

/**
 * XXX needs more optimization
 * 
 * XXX supports boxing and unboxing, but not varargs methods
 */
public class Multimethod {

    private final SimpleType<?> type;
    private final String methodName;
    private final int arity;

    private final FunctionDescriptor[] methods;

    private Multimethod(SimpleType<?> _type, String _methodName, int _arity) {
        type = _type;
        methodName = _methodName;
        arity = _arity;

        // sort by specificity
        methods = getMethodsByArity(type, methodName, arity);

        // System.out.println("Constructing multimethod:");
        // for (MethodDescriptor m : methods)
        // System.out.println(" method == " + m.method);
    }
    
    public static Multimethod create(Class<?> type, String methodName,
            int arity) {
        return create(SimpleType.make(type), methodName, arity);
    }

    public static Multimethod create(SimpleType<?> type, String methodName,
            int arity) {
        return new Multimethod(type, methodName, arity);
    }

    public final Object invokeStatic(Object... args) {
        return invoke(null, args);
    }

    public Object invokeStaticSpecifiedTypes(SimpleType<?>[] argTypes,
            Object... args) {
        return invokeSpecifiedTypes(null, argTypes, args);
    }

    public final Object invoke(Object self, Object... args) {
        return invokeSpecifiedTypes(self, SimpleType.getClasses(args), args);
    }

    public final Object invokeSpecifiedTypes(Object self,
            SimpleType<?>[] argTypes, Object... args) {

        FunctionDescriptor mostAppropriate = getBestOverload(argTypes);

        if (mostAppropriate.varArgs) {
            // cook args

            Class<?>[] trueParms = mostAppropriate.getTrueParameterTypes();
            int trueArity = trueParms.length;

            Object[] newArgs = new Object[trueArity];
            System.arraycopy(args, 0, newArgs, 0, trueArity - 1);

            int varArgsSize = mostAppropriate.arity - trueArity + 1;
            newArgs[trueArity - 1] = Array.newInstance(trueParms[trueArity - 1]
                    .getComponentType(), varArgsSize);

            System.arraycopy(args, trueArity - 1, newArgs[trueArity - 1], 0,
                    varArgsSize);

            args = newArgs;
        }
        
        return mostAppropriate.invoke(self, args);


    }

    private FunctionDescriptor getBestOverload(SimpleType<?>[] argTypes) {

        // XXX this is expensive as hell, but required by the JLS.

        // XXX figure out some way of optimizing this while preserving
        // semantics.

        /*
         * JLS 3rd edition: 15.12.2 (Compile-Time Step 2: Determine Method
         * Signature) says:
         * 
         * The process of determining applicability begins by determining the
         * potentially applicable methods (¤15.12.2.1). The remainder of the
         * process is split into three phases.
         * 
         * Discussion: The purpose of the division into phases is to ensure
         * compatibility with older versions of the Java programming language.
         * 
         * The first phase (¤15.12.2.2) performs overload resolution without
         * permitting boxing or unboxing conversion, or the use of variable
         * arity method invocation. If no applicable method is found during this
         * phase then processing continues to the second phase.
         * 
         * Discussion: This guarantees that any calls that were valid in older
         * versions of the language are not considered ambiguous as a result of
         * the introduction of variable arity methods, implicit boxing and/or
         * unboxing.
         * 
         * The second phase (¤15.12.2.3) performs overload resolution while
         * allowing boxing and unboxing, but still precludes the use of variable
         * arity method invocation. If no applicable method is found during this
         * phase then processing continues to the third phase.
         * 
         * Discussion: This ensures that a variable arity method is never
         * invoked if an applicable fixed arity method exists.
         * 
         * The third phase (¤15.12.2.4) allows overloading to be combined with
         * variable arity methods, boxing and unboxing.
         */

        FunctionDescriptor r;
        // Phase 1: legacy behavior
        r = getBestOverload(argTypes, false, false);
        if (r != null)
            return r;

        // Phase 2: allow boxing, no varargs
        r = getBestOverload(argTypes, true, false);
        if (r != null)
            return r;

        // Phase 3: all in: boxing and varargs
        r = getBestOverload(argTypes, true, true);
        if (r != null)
            return r;

        throw new NotFoundReflectException("No match for " + type + "."
                + methodName + "(" + SimpleType.toString(argTypes) + ")");
    }

    private FunctionDescriptor getBestOverload(SimpleType<?>[] argTypes,
            boolean allowBoxing, boolean allowVarargs) {

        // this is the big performance bottleneck for multimethod invocations.

        // the strategy right now is to iterate through the available methods
        // (presorted), and return the first applicable one.

        // the challenge is that in order to detect ambiguity, we need to keep
        // looking after we've found one.

        final int length = methods.length;
        for (int i = 0; i < length; i++) {

            final FunctionDescriptor m = methods[i];

            if (!allowVarargs && m.varArgs) {
                // not allowing varargs: skip.
                continue;
            }

            if (!isApplicable(m.parameterTypes, argTypes, allowBoxing)) {
                // not applicable, don't even bother.
                continue;
            }

            // check for ambiguity
            if (!m.strictlyBetterThanNextChoice) {
                int index = i + 1;

                FunctionDescriptor possibleAmbiguity;
                do {
                    possibleAmbiguity = methods[index++];
                    if (!allowVarargs && possibleAmbiguity.varArgs)
                        continue;

                    if (isApplicable(possibleAmbiguity.parameterTypes,
                            argTypes, allowBoxing))
                        throw new AmbiguousMethodInvocationException(
                                methodName, Arrays.asList(argTypes),
                                getAmbiguousMethods(argTypes, i));
                } while (!possibleAmbiguity.strictlyBetterThanNextChoice);

            }

            return m;
        }

        return null;

    }

    private List<AccessibleObject> getAmbiguousMethods(SimpleType<?>[] argTypes,
            int startIdx) {

        List<AccessibleObject> r = new ArrayList<AccessibleObject>();

        int i = startIdx;
        while (!methods[i].strictlyBetterThanNextChoice) {

            if (isApplicable(methods[i].parameterTypes, argTypes, true))
                r.add(methods[i].getFunction());

            i++;
        }

        if (r.isEmpty()) {
            throw new AssertionError();
        }

        return r;
    }

    private static boolean isMoreSpecific(final SimpleType<?>[] aTypes,
            final SimpleType<?>[] bTypes) {

        final int length = aTypes.length;
        for (int i = 0; i < length; i++)
            // XXX is this sorting ok?
            if (!bTypes[i].isMethodParmAssignableFrom(aTypes[i], true))
                return false;

        return true;
    }

    private static boolean isApplicable(final SimpleType<?>[] parameterTypes,
            final SimpleType<?>[] argTypes, boolean allowBoxing) {

        final int length = argTypes.length;
        for (int i = 0; i < length; i++) {
            final SimpleType<?> parmType = parameterTypes[i];
            final SimpleType<?> argType = argTypes[i];

            if (!parmType.isMethodParmAssignableFrom(argType, allowBoxing))
                return false;

        }

        return true;
    }

    public static class MultimethodException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public MultimethodException() {
            super();
        }

        public MultimethodException(String msg) {
            super(msg);
        }

        public MultimethodException(String msg, Throwable ex) {
            super(msg, ex);
        }
    }

    public String toString() {
        return type.getName() + "." + methodName + "/" + arity;
    }

    private static FunctionDescriptor[] getMethodsByArity(SimpleType<?> type,
            String methodName, int arity) {
        List<FunctionDescriptor> r = new ArrayList<FunctionDescriptor>();

        if (methodName.equals("<init>")) {
            for (Constructor<?> m : type.getJavaClass().getConstructors()) {

                // Note that a varargs method would get added twice here

                if (m.getParameterTypes().length == arity)
                    r.add(new ConstructorDescriptor(m, arity, false));

                if (m.isVarArgs() && m.getParameterTypes().length <= arity)
                    r.add(new ConstructorDescriptor(m, arity, true));
            }
        } else {
            for (Method m : type.getJavaClass().getMethods()) {
                // skip bad method names
                if (!m.getName().equals(methodName))
                    continue;

                // Note that a varargs method would get added twice here

                if (m.getParameterTypes().length == arity)
                    r.add(new MethodDescriptor(m, arity, false));

                if (m.isVarArgs() && m.getParameterTypes().length <= arity)
                    r.add(new MethodDescriptor(m, arity, true));
            }
        }
        
        FunctionDescriptor[] _r = r.toArray(new FunctionDescriptor[r.size()]);
        Arrays.sort(_r);

        // precalculate overload comparison
        for (int i = 0; i < _r.length; i++) {

            // last one is always better than nothing.
            if (i + 1 == _r.length) {
                _r[i].strictlyBetterThanNextChoice = true;

            } else {
                int comparison = _r[i].compareTo(_r[i + 1]);
                _r[i].strictlyBetterThanNextChoice = comparison != 0;
            }
        }

        if (_r.length == 0)
            throw new NotFoundReflectException("No such method: " + type + "."
                    + methodName + "/" + arity);

        return _r;
    }

    /**
     * 
     * 
     */
    public abstract static class FunctionDescriptor implements
            Comparable<FunctionDescriptor> {

        final AccessibleObject function;
        final int arity;
        final boolean varArgs; // true if this should be INTERPRETED as a
        // varargs method
        final SimpleType<?>[] parameterTypes;
        boolean strictlyBetterThanNextChoice;

        public FunctionDescriptor(AccessibleObject m, int _arity, boolean _varArgs, Class<?>[] _parameterTypes) {
            function = m;
            arity = _arity;
            varArgs = _varArgs;

            if (varArgs)
                parameterTypes = makeVarParms(_parameterTypes, arity);
            else
                parameterTypes = SimpleType.make(_parameterTypes);
        }

        public abstract Class<?>[] getTrueParameterTypes();

        public AccessibleObject getFunction() {
            return function;
        }

        public abstract Object invoke(Object self, Object[] args);

        protected static SimpleType<?>[] makeVarParms(Class<?>[] parameterTypes, int arity) {

            SimpleType<?>[] r = new SimpleType<?>[arity];

            // last argument is varargs.
            for (int i = 0; i < parameterTypes.length - 1; i++)
                r[i] = SimpleType.make(parameterTypes[i]);

            Class<?> varArgClass = parameterTypes[parameterTypes.length - 1]
                    .getComponentType();
            SimpleType<?> varArgType = SimpleType.make(varArgClass);

            for (int i = parameterTypes.length - 1; i < r.length; i++)
                r[i] = varArgType;

            return r;
        }

        public int compareTo(FunctionDescriptor that) {

            if (isMoreSpecific(this.parameterTypes, that.parameterTypes))
                return -1;
            else if (isMoreSpecific(that.parameterTypes, this.parameterTypes))
                return 1;
            else
                return 0;
        }

        public String toString() {
            return function.toString();
        }

    }
    
    public static class MethodDescriptor extends FunctionDescriptor {
        
        private final Method method;

        public MethodDescriptor(Method m, int _arity, boolean _varArgs) {
            super(m, _arity, _varArgs, m.getParameterTypes());
            method = m;
        }

        @Override
        public Class<?>[] getTrueParameterTypes() {
            return method.getParameterTypes();
        }
        
        @Override
        public Object invoke(Object self, Object[] args) {

            try {
                return method.invoke(self, args);
            } catch (IllegalAccessException ex) {
                throw new MultimethodException("Could not access method "
                        + toString(), ex);
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getTargetException();
                if (cause instanceof RuntimeException)
                    throw (RuntimeException) cause;
                if (cause instanceof Error)
                    throw (Error) cause;
                throw new MultimethodException("Error invoking method "
                        + toString(), ex);
            }
        }
    }
    
    
    public static class ConstructorDescriptor extends FunctionDescriptor {
        
        private final Constructor<?> constructor;

        public ConstructorDescriptor(Constructor<?> m, int _arity, boolean _varArgs) {
            super(m, _arity, _varArgs, m.getParameterTypes());
            constructor = m;
        }
        
        @Override
        public Class<?>[] getTrueParameterTypes() {
            return constructor.getParameterTypes();
        }

        @Override
        public Object invoke(Object self, Object[] args) {

            try {
                return constructor.newInstance(args);
            } catch (IllegalAccessException ex) {
                throw new MultimethodException("Could not access method "
                        + toString(), ex);
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getTargetException();
                if (cause instanceof RuntimeException)
                    throw (RuntimeException) cause;
                if (cause instanceof Error)
                    throw (Error) cause;
                throw new MultimethodException("Error invoking method "
                        + toString(), ex);
            } catch (IllegalArgumentException ex) {
                throw new MultimethodException("Error invoking method "
                        + toString(), ex);
            } catch (InstantiationException ex) {
                throw new MultimethodException("Error invoking method "
                        + toString(), ex);
            }
        }
    }


}
