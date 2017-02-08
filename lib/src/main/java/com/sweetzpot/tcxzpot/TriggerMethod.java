package com.sweetzpot.tcxzpot;

public enum TriggerMethod implements TCXSerializable {
    MANUAL("Manual"),
    DISTANCE("Distance"),
    LOCATION("Location"),
    TIME("Time"),
    HEART_RATE("HeartRate");

    private final String rawValue;

    TriggerMethod(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<TriggerMethod>" + rawValue + "</TriggerMethod>");
    }
}
