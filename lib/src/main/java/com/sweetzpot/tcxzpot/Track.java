package com.sweetzpot.tcxzpot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track implements TCXSerializable {

    public static Track trackWith(Trackpoint... trackpoints) {
        return new Track(trackpoints);
    }

    public static Track trackWith(List<Trackpoint> trackpoints) {
        return new Track(trackpoints);
    }

    private List<Trackpoint> trackpoints = new ArrayList<>();

    public Track() {}

    public Track(List<Trackpoint> trackpoints) {
        this.trackpoints = new ArrayList<>(trackpoints);
    }

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
