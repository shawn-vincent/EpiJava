/*
 * 
 */
package com.epijava.lang.type;

/**
 * 
 *
 */
public class Package extends ScopeDefinition {
    
    private final DefinitionLoader loader;
    private final JavaName<Package> packageName;
    
    public Package(DefinitionLoader _loader, JavaName<Package> _name) {
        loader = _loader;
        packageName = _name;
    }

    public JavaName<Package> getName() {
        return packageName;
    }
    
    @Override
    public Type getType() {
        throw new UnsupportedOperationException();
    }

    public <T extends Definition> T getDefinition(JavaName<T> name) {
        if (name.isTypeName())
            return name.cast(loader.getDefinition(JavaName.type(packageName
                    .getName()
                    + "." + name.getName())));
        else
            return loader.getDefinition(name);
    }

}
