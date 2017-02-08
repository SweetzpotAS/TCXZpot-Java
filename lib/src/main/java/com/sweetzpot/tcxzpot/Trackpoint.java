package com.sweetzpot.tcxzpot;

public class Trackpoint {

    private final TCXDate time;
    private final Position position;
    private final Double altitude;
    private final Double distance;
    private final HeartRate heartRate;
    private final Cadence cadence;
    private final SensorState sensorState;

    public Trackpoint(TCXDate time, Position position, Double altitude, Double distance, HeartRate heartRate,
                      Cadence cadence, SensorState sensorState) {
        this.time = time;
        this.position = position;
        this.altitude = altitude;
        this.distance = distance;
        this.heartRate = heartRate;
        this.cadence = cadence;
        this.sensorState = sensorState;
    }
}
