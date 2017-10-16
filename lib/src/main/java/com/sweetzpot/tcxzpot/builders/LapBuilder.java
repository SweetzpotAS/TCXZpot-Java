package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.Cadence;
import com.sweetzpot.tcxzpot.HeartRate;
import com.sweetzpot.tcxzpot.Intensity;
import com.sweetzpot.tcxzpot.Lap;
import com.sweetzpot.tcxzpot.Notes;
import com.sweetzpot.tcxzpot.TCXDate;
import com.sweetzpot.tcxzpot.TCXExtension;
import com.sweetzpot.tcxzpot.Track;
import com.sweetzpot.tcxzpot.TriggerMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LapBuilder {

    private TCXExtension[] extensions;

    public static LapBuilder aLap(TCXDate startTime) {
        return new LapBuilder(startTime);
    }

    private TCXDate startTime;
    private Double totalTime;
    private Double distance;
    private Double maximumSpeed;
    private Integer calories;
    private HeartRate averageHeartRate;
    private HeartRate maximumHeartRate;
    private Intensity intensity;
    private Cadence cadence;
    private TriggerMethod triggerMethod;
    private List<Track> tracks;
    private Notes notes;

    private LapBuilder(TCXDate startTime) {
        this.startTime = startTime;
    }

    public LapBuilder withTotalTime(double totalTime) {
        this.totalTime = totalTime;
        return this;
    }

    public LapBuilder withDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public LapBuilder withMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
        return this;
    }

    public LapBuilder withCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public LapBuilder withAverageHeartRate(HeartRate averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
        return this;
    }

    public LapBuilder withMaximumHeartRate(HeartRate maximumHeartRate) {
        this.maximumHeartRate = maximumHeartRate;
        return this;
    }

    public LapBuilder withIntensity(Intensity intensity) {
        this.intensity = intensity;
        return this;
    }

    public LapBuilder withCadence(Cadence cadence) {
        this.cadence = cadence;
        return this;
    }

    public LapBuilder withTriggerMethod(TriggerMethod triggerMethod) {
        this.triggerMethod = triggerMethod;
        return this;
    }

    public LapBuilder withTracks(Track... tracks) {
        this.tracks = new ArrayList<>();
        Collections.addAll(this.tracks, tracks);
        return this;
    }

    public LapBuilder withTracks(List<Track> tracks) {
        this.tracks = tracks;
        return this;
    }

    public LapBuilder withNotes(Notes notes) {
        this.notes = notes;
        return this;
    }

    public LapBuilder withExtensions(TCXExtension... extensions) {
        this.extensions = extensions;
        return this;
    }

    public Lap build() {
        validateArguments();
        return new Lap(startTime, totalTime, distance, maximumSpeed, calories, averageHeartRate,
                maximumHeartRate, intensity, cadence, triggerMethod, tracks, notes, extensions);
    }

    private void validateArguments() {
        if(startTime == null) {
            throw new IllegalArgumentException("Lap must have a Start Time");
        }
        if(totalTime == null) {
            throw new IllegalArgumentException("Lap must have a Total Time");
        }
        if(distance == null) {
            throw new IllegalArgumentException("Lap must have a Distance");
        }
        if(calories == null) {
            throw new IllegalArgumentException("Lap must have a Calories");
        }
        if(intensity == null) {
            throw new IllegalArgumentException("Lap must have an Intensity");
        }
        if(triggerMethod == null) {
            throw new IllegalArgumentException("Lap must have a Trigger Method");
        }
    }
}
