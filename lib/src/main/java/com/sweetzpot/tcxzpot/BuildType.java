package com.sweetzpot.tcxzpot;

public enum BuildType {
    INTERNAL("Internal"),
    ALPHA("Alpha"),
    BETA("Beta"),
    RELEASE("Release");

    private final String rawValue;

    BuildType(String rawValue) {
        this.rawValue = rawValue;
    }
}
