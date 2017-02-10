package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.AbstractSource;
import com.sweetzpot.tcxzpot.Activity;
import com.sweetzpot.tcxzpot.Lap;
import com.sweetzpot.tcxzpot.Notes;
import com.sweetzpot.tcxzpot.Sport;
import com.sweetzpot.tcxzpot.TCXDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityBuilder {

    public static ActivityBuilder activity(Sport sport) {
        return new ActivityBuilder(sport);
    }

    private Sport sport;
    private TCXDate id;
    private List<Lap> laps;
    private Notes notes;
    private AbstractSource creator;

    private ActivityBuilder(Sport sport) {
        this.sport = sport;
    }

    public ActivityBuilder withID(TCXDate id) {
        this.id = id;
        return this;
    }

    public ActivityBuilder withLaps(Lap... laps) {
        this.laps = new ArrayList<>();
        Collections.addAll(this.laps, laps);
        return this;
    }

    public ActivityBuilder withLaps(List<Lap> laps) {
        this.laps = laps;
        return this;
    }

    public ActivityBuilder withLaps(LapBuilder... laps) {
        this.laps = new ArrayList<>();
        for(LapBuilder lapBuilder : laps) {
            this.laps.add(lapBuilder.build());
        }
        return this;
    }

    public ActivityBuilder withNotes(Notes notes) {
        this.notes = notes;
        return this;
    }

    public ActivityBuilder withCreator(AbstractSource creator) {
        this.creator = creator;
        return this;
    }

    public Activity build() {
        validateArguments();
        return new Activity(id, laps, notes, creator, sport);
    }

    private void validateArguments() {
        if(sport == null) {
            throw new IllegalArgumentException("Activity must have a Sport");
        }
        if(id == null) {
            throw new IllegalArgumentException("Activity must have an Id");
        }
        if(laps == null || laps.size() == 0) {
            throw new IllegalArgumentException("Activity must have at least one Lap");
        }
    }

}
