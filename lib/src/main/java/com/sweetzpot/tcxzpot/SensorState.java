package com.sweetzpot.tcxzpot;

public enum SensorState implements TCXSerializable {
    PRESENT("Present"),
    ABSENT("Absent");

    private final String rawValue;

    SensorState(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<SensorState>" + rawValue + "</SensorState>");
    }
}
