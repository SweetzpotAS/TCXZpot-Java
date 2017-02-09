package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.SensorState.ABSENT;
import static com.sweetzpot.tcxzpot.builders.TrackpointBuilder.aTrackpoint;
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

        aTrackpoint().onTime(time)
                .withPosition(position)
                .withAltitude(123)
                .withDistance(1200)
                .withHeartRate(heartRate)
                .withCadence(cadence)
                .withSensorState(ABSENT)
                .build().serialize(serializer);

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

        aTrackpoint().onTime(time)
                .build().serialize(serializer);

        verify(serializer).print("<Trackpoint>");
        verify(serializer).print("<Time>");
        verify(time).serialize(serializer);
        verify(serializer).print("</Time>");
        verify(serializer).print("</Trackpoint>");
        verifyNoMoreInteractions(serializer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingTime() throws Exception {
        aTrackpoint().build();
    }
}