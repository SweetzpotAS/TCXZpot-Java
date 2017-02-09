package com.sweetzpot.tcxzpot;

public class Notes implements TCXSerializable {

    private final String notes;

    public Notes(String notes) {
        this.notes = notes;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Notes>" + notes + "</Notes>");
    }
}
