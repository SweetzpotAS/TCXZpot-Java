package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class TrackpointTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        TCXDate time = mock(TCXDate.class);
        Position position = mock(Position.class);
        HeartRate heartRate = mock(HeartRate.class);
        Cadence cadence = mock(Cadence.class);

        Trackpoint trackpoint = new Trackpoint(time, position, 123.0, 1200.0, heartRate, cadence, SensorState.ABSENT);
        trackpoint.serialize(serializer);

        verify(serializer).print("<Trackpoint>");
        verify(serializer).print("<Time>");
        verify(time).serialize(serializer);
        verify(serializer).print("</Time>");
        verify(position).serialize(serializer);
        verify(serializer).print("<AltitudeMeters>123.0</AltitudeMeters>");
        verify(serializer).print("<DistanceMeters>1200.0</DistanceMeters>");
        verify(serializer).print("<HeartRateBpm>");
        verify(heartRate).serialize(serializer);
        verify(serializer).print("</HeartRateBpm>");
        verify(cadence).serialize(serializer);
        verify(serializer).print("<SensorState>Absent</SensorState>");
        verify(serializer).print("</Trackpoint>");
    }

    @Test
    public void producesCorrectSerializationWithAbsentParameters() throws Exception {
        Serializer serializer = mock(Serializer.class);
        TCXDate time = mock(TCXDate.class);

        Trackpoint trackpoint = new Trackpoint(time, null, null, null, null, null, null);
        trackpoint.serialize(serializer);

        verify(serializer).print("<Trackpoint>");
        verify(serializer).print("<Time>");
        verify(time).serialize(serializer);
        verify(serializer).print("</Time>");
        verify(serializer).print("</Trackpoint>");
        verifyNoMoreInteractions(serializer);
    }
}