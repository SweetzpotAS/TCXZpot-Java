package com.sweetzpot.tcxzpot;

import java.util.List;

public class Activity {

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
}
