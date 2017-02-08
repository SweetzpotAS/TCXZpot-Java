package com.sweetzpot.tcxzpot;

public enum TriggerMethod {
    MANUAL("Manual"),
    DISTANCE("Distance"),
    LOCATION("Location"),
    TIME("Time"),
    HEART_RATE("HeartRate");

    private final String rawValue;

    TriggerMethod(String rawValue) {
        this.rawValue = rawValue;
    }
}
