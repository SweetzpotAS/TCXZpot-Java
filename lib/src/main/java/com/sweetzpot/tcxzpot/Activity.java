package com.sweetzpot.tcxzpot;

import java.util.List;

public class Activity implements TCXSerializable {

    private final TCXDate id;
    private final List<Lap> laps;
    private final String notes;
    private final AbstractSource creator;
    private final Sport sport;

    public Activity(TCXDate id, List<Lap> laps, String notes, AbstractSource creator, Sport sport) {
        this.id = id;
        this.laps = laps;
        this.notes = notes;
        this.creator = creator;
        this.sport = sport;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Activity Sport=\"" + sport.toString() + "\">");
        serializer.print("<Id>" + id.toString() + "</Id>");
        for(Lap lap : laps) {
            lap.serialize(serializer);
        }
        if(notes != null) serializer.print("<Notes>" + notes + "</Notes>");
        if(creator != null) {
            serializer.print("<Creator xsi:type=\"" + creator.tcxType() + "\">");
            creator.serialize(serializer);
            serializer.print("</Creator>");
        }
        serializer.print("</Activity>");
    }
}
