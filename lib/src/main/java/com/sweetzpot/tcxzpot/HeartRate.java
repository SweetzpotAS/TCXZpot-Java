package com.sweetzpot.tcxzpot;

public class HeartRate implements TCXSerializable {

    public static HeartRate bpm(int value) {
        return new HeartRate(value);
    }

    private final int value;

    public HeartRate(int value) {
        this.value = value;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Value>" + value + "</Value>");
    }
}
