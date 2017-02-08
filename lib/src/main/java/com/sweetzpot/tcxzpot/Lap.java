package com.sweetzpot.tcxzpot;

public class Lap {

    private final double totalTime;
    private final double distance;
    private final Double maximumSpeed;
    private final int calories;
    private final HeartRate averageHeartRate;
    private final HeartRate maximumHeartRate;
    private final Intensity intensity;
    private final Cadence cadence;
    private final TriggerMethod triggerMethod;
    private final Track track;
    private final String notes;

    public Lap(double totalTime, double distance, Double maximumSpeed, int calories, HeartRate averageHeartRate,
               HeartRate maximumHeartRate, Intensity intensity, Cadence cadence, TriggerMethod triggerMethod,
               Track track, String notes) {
        this.totalTime = totalTime;
        this.distance = distance;
        this.maximumSpeed = maximumSpeed;
        this.calories = calories;
        this.averageHeartRate = averageHeartRate;
        this.maximumHeartRate = maximumHeartRate;
        this.intensity = intensity;
        this.cadence = cadence;
        this.triggerMethod = triggerMethod;
        this.track = track;
        this.notes = notes;
    }
}
