package com.sweetzpot.tcxzpot;

public enum Intensity implements TCXSerializable {
    ACTIVE("Active"),
    RESTING("Resting");

    private final String rawValue;

    Intensity(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Intensity>" + rawValue + "</Intensity>");
    }
}
