/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 *
 */
public class SystemDefinitionLoader extends ClassLoaderDefinitionLoader {

    private static final SystemDefinitionLoader Inst = new SystemDefinitionLoader();
    
    public static SystemDefinitionLoader getInstance() { return Inst; }
    
    public SystemDefinitionLoader() {
        this(SystemDefinitionLoader.class.getClassLoader());
    }

    public SystemDefinitionLoader(ClassLoader loader) {
        super(loader);
    }

    
    @Override
    protected Type loadType(JavaName<Type> name) {

        switch (name.getName().charAt(0)) {
        case 'i':
            if (name.getName().equals("int"))
                return SimpleType.make(int.class);
            break;
        case 'd':
            if (name.getName().equals("double"))
                return SimpleType.make(double.class);
            break;
        case 'l':
            if (name.getName().equals("long"))
                return SimpleType.make(long.class);
            break;
        case 'f':
            if (name.getName().equals("float"))
                return SimpleType.make(float.class);
            break;
        case 's':
            if (name.getName().equals("short"))
                return SimpleType.make(short.class);
            break;
        case 'c':
            if (name.getName().equals("char"))
                return SimpleType.make(char.class);
            break;
        case 'b':
            if (name.getName().equals("boolean"))
                return SimpleType.make(boolean.class);
            if (name.getName().equals("byte"))
                return SimpleType.make(byte.class);
            break;
        case 'v':
            if (name.getName().equals("void"))
                return SimpleType.make(void.class);
            break;
        }

        return super.loadType(name);
    }

}
