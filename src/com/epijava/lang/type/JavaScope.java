/*
 * 
 */
package com.epijava.lang.type;


/**
 * Represents a Java scope.
 * 
 * <p>
 * There are 4 types of names in Java: package names, type names, method names
 * and expression (field and local variable) names.
 * 
 * <p>
 * Syntactically, Java also defines two more classifications: AmbiguousNames and
 * PackageOrTypeNames. These are not represented here, since they go away by the
 * time you ask a scope for them.
 */
public interface JavaScope {

    public <T extends Definition> T getDefinition(JavaName<T> name);

    /**
     * 
     */
    public class EmptyScope implements JavaScope {

        public <T extends Definition> T getDefinition(JavaName<T> name) {
            return null;
        }

    }


}
