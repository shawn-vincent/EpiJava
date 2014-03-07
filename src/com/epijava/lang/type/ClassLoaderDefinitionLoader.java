/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 *
 */
public class ClassLoaderDefinitionLoader extends DefinitionLoader {

    private final ClassLoader classLoader;
    
    public ClassLoaderDefinitionLoader(DefinitionLoader parentLoader, ClassLoader _classLoader) {
        super(parentLoader);
        classLoader = _classLoader;
    }
    
    public ClassLoaderDefinitionLoader(ClassLoader _classLoader) {
        this(null, _classLoader);
    }

    @Override
    protected Type loadType(JavaName<Type> name) {
        try {
            Class<?> clazz = classLoader.loadClass(name.getName());
            return SimpleType.make(clazz);
        } catch (ClassNotFoundException e) {
            // ignore this exception?  Go to parent typeloader?
            return null;
        }
    }

}
