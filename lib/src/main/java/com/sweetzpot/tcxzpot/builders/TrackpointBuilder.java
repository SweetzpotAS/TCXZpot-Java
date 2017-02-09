package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.Cadence;
import com.sweetzpot.tcxzpot.HeartRate;
import com.sweetzpot.tcxzpot.Position;
import com.sweetzpot.tcxzpot.SensorState;
import com.sweetzpot.tcxzpot.TCXDate;
import com.sweetzpot.tcxzpot.Trackpoint;

public class TrackpointBuilder {

    public static TrackpointBuilder aTrackpoint() {
        return new TrackpointBuilder();
    }

    private TrackpointBuilder() {}

    private TCXDate time;
    private Position position;
    private Double altitude;
    private Double distance;
    private HeartRate heartRate;
    private Cadence cadence;
    private SensorState sensorState;

    public TrackpointBuilder onTime(TCXDate time) {
        this.time = time;
        return this;
    }

    public TrackpointBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public TrackpointBuilder withPosition(PositionBuilder positionBuilder) {
        this.position = positionBuilder.build();
        return this;
    }

    public TrackpointBuilder withAltitude(double altitude) {
        this.altitude = altitude;
        return this;
    }

    public TrackpointBuilder withDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public TrackpointBuilder withHeartRate(HeartRate heartRate) {
        this.heartRate = heartRate;
        return this;
    }

    public TrackpointBuilder withCadence(Cadence cadence) {
        this.cadence = cadence;
        return this;
    }

    public TrackpointBuilder withSensorState(SensorState sensorState) {
        this.sensorState = sensorState;
        return this;
    }

    public Trackpoint build() {
        validateArguments();
        return new Trackpoint(time, position, altitude, distance, heartRate, cadence, sensorState);
    }

    private void validateArguments() {
        if(time == null) {
            throw new IllegalArgumentException("Trackpoint must have a Time");
        }
    }
}
