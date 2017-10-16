package com.sweetzpot.tcxzpot;

import java.util.List;

import static com.sweetzpot.tcxzpot.util.TCXExtensionSerialization.serializeExtensions;

public class Activity implements TCXSerializable {

    private final TCXDate id;
    private final List<Lap> laps;
    private final Notes notes;
    private final AbstractSource creator;
    private final Sport sport;
    private final TCXExtension[] extensions;

    public Activity(TCXDate id, List<Lap> laps, Notes notes, AbstractSource creator, Sport sport, TCXExtension... extensions) {
        this.id = id;
        this.laps = laps;
        this.notes = notes;
        this.creator = creator;
        this.sport = sport;
        this.extensions = extensions;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Activity Sport=\"" + sport.toString() + "\">");
        serializer.print("<Id>" + id.toString() + "</Id>");
        for(Lap lap : laps) {
            lap.serialize(serializer);
        }
        if(notes != null) notes.serialize(serializer);
        if(creator != null) {
            serializer.print("<Creator xsi:type=\"" + creator.tcxType() + "\">");
            creator.serialize(serializer);
            serializer.print("</Creator>");
        }
        serializeExtensions(extensions, serializer);
        serializer.print("</Activity>");
    }
}
