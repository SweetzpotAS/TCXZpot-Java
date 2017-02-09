package com.sweetzpot.tcxzpot;

public class Cadence implements TCXSerializable {

    public static Cadence cadence(int value) {
        return new Cadence(value);
    }

    private final int value;

    public Cadence(int value) {
        this.value = value;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Cadence>" + value + "</Cadence>");
    }
}
