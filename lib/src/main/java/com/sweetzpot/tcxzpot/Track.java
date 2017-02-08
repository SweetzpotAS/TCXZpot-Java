package com.sweetzpot.tcxzpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track implements TCXSerializable {

    private List<Trackpoint> trackpoints = new ArrayList<>();;

    public Track() {}

    public Track(Trackpoint... trackpoints) {
        Collections.addAll(this.trackpoints, trackpoints);
    }

    public void add(Trackpoint trackpoint) {
        trackpoints.add(trackpoint);
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Track>");
        for(Trackpoint trackpoint : trackpoints) {
            trackpoint.serialize(serializer);
        }
        serializer.print("</Track>");
    }
}
