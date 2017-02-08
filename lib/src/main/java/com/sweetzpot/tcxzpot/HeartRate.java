package com.sweetzpot.tcxzpot;

public class HeartRate implements TCXSerializable {

    private final int value;

    public HeartRate(int value) {
        this.value = value;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Value>" + value + "</Value>");
    }
}
