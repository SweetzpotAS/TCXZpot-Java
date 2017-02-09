package com.sweetzpot.tcxzpot;

public abstract class AbstractSource implements TCXSerializable {

    protected final String name;

    public AbstractSource(String name) {
        this.name = name;
    }
}
