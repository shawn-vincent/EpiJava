package com.epijava.lang.type;

public abstract class Function extends Definition {

    public Function() {
        super();
    }
    
    public Function(Type _enclosingType) {
        super(_enclosingType);
    }

    @Override
    public abstract FunctionType getType();

}
