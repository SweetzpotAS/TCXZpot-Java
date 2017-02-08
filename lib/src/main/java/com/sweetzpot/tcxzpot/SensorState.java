package com.sweetzpot.tcxzpot;

public enum SensorState {
    PRESENT("Present"),
    ABSENT("Absent");

    private final String rawValue;

    SensorState(String rawValue) {
        this.rawValue = rawValue;
    }
}
