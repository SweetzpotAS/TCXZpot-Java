package com.sweetzpot.tcxzpot;

public class Cadence implements TCXSerializable {

    private final int value;

    public Cadence(int value) {
        this.value = value;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Cadence>" + value + "</Cadence>");
    }
}
