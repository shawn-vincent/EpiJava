/*
 * 
 */
package com.epijava.lang.tree;

import com.epijava.util.*;

/**
 * XXX is this different than NestedTypeReference!?
 *
 */
public class TypeMemberReference extends TypeReference {

    private final TypeReference baseType;
    private final String memberName;
    
    /**
     * 
     */
    public TypeMemberReference(Locus _locus, TypeReference _baseType, String _memberName) {
        super(_locus);
        baseType = _baseType;
        memberName = _memberName;
    }
    
    public TypeReference getBaseType() { return baseType; }
    public String getMemberName() { return memberName; }

}
