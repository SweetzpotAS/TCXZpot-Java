package com.sweetzpot.tcxzpot;

public class Trackpoint implements TCXSerializable {

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

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Trackpoint>");
        serializer.print("<Time>");
        time.serialize(serializer);
        serializer.print("</Time>");
        if(position != null) position.serialize(serializer);
        if(altitude != null) serializer.print("<AltitudeMeters>" + altitude + "</AltitudeMeters>");
        if(distance != null) serializer.print("<DistanceMeters>" + distance + "</DistanceMeters>");
        if(heartRate != null) {
            serializer.print("<HeartRateBpm>");
            heartRate.serialize(serializer);
            serializer.print("</HeartRateBpm>");
        }
        if(cadence != null) cadence.serialize(serializer);
        if(sensorState != null) sensorState.serialize(serializer);
        serializer.print("</Trackpoint>");
    }
}
