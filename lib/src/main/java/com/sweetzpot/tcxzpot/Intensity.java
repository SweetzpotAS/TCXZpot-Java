package com.sweetzpot.tcxzpot;

public enum Intensity {
    ACTIVE("Active"),
    RESTING("Resting");

    private final String rawValue;

    Intensity(String rawValue) {
        this.rawValue = rawValue;
    }
}
