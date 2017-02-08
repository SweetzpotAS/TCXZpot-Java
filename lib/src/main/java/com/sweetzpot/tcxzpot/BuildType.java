package com.sweetzpot.tcxzpot;

public enum BuildType implements TCXSerializable {
    INTERNAL("Internal"),
    ALPHA("Alpha"),
    BETA("Beta"),
    RELEASE("Release");

    private final String rawValue;

    BuildType(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Type>" + rawValue + "</Type>");
    }
}
