/*
 *
 *
 */
package com.epijava.lang.tree;

import java.util.ArrayList;
import java.util.List;

import com.epijava.lang.type.*;
import com.epijava.util.*;

/**
 * A Java type declaration
 **/
public class TypeDeclaration extends MemberDeclaration<Type> {

    private List<MemberDeclaration<?>> members = new ArrayList<MemberDeclaration<?>>();

    public TypeDeclaration (Locus _locus, String _name) { super(_locus, _name); }
   
    @AstNode
    public List<MemberDeclaration<?>> getMembers() { return members; }
    public TypeDeclaration add(MemberDeclaration<?> member) {
        members.add(member);
        return this;
    }

    @Override
    public JavaNamespace<Type> getNamespace() {
        return JavaNamespace.Type;
    }
}