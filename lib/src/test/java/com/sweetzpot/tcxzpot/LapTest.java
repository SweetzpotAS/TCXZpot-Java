package com.sweetzpot.tcxzpot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.tcxzpot.TCXDate.tcxDate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LapTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        HeartRate averageHeartRate = mock(HeartRate.class);
        HeartRate maximumHeartRate = mock(HeartRate.class);
        Cadence cadence = mock(Cadence.class);
        Track track = mock(Track.class);
        List<Track> tracks = Arrays.asList(track);

        Lap lap = new Lap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56), 651, 350, 10.0, 1534,
                averageHeartRate, maximumHeartRate, Intensity.ACTIVE, cadence, TriggerMethod.MANUAL,
                tracks, "Notes for this lap");
        lap.serialize(serializer);

        verify(serializer).print("<Lap StartTime=\"2017-02-01T12:34:56.000Z\">");
        verify(serializer).print("<TotalTimeSeconds>651.0</TotalTimeSeconds>");
        verify(serializer).print("<DistanceMeters>350.0</DistanceMeters>");
        verify(serializer).print("<MaximumSpeed>10.0</MaximumSpeed>");
        verify(serializer).print("<Calories>1534</Calories>");
        verify(serializer).print("<AverageHeartRateBpm>");
        verify(averageHeartRate).serialize(serializer);
        verify(serializer).print("</AverageHeartRateBpm>");
        verify(serializer).print("<MaximumHeartRateBpm>");
        verify(maximumHeartRate).serialize(serializer);
        verify(serializer).print("</MaximumHeartRateBpm>");
        verify(serializer).print("<Intensity>Active</Intensity>");
        verify(cadence).serialize(serializer);
        verify(serializer).print("<TriggerMethod>Manual</TriggerMethod>");
        verify(track).serialize(serializer);
        verify(serializer).print("<Notes>Notes for this lap</Notes>");
        verify(serializer).print("</Lap>");
    }

    @Test
    public void producesCorrectSerializationWithMissingArguments() throws Exception {
        Serializer serializer = mock(Serializer.class);

        Lap lap = new Lap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56), 651, 350, null, 1534,
                null, null, Intensity.ACTIVE, null, TriggerMethod.MANUAL,
                null, null);
        lap.serialize(serializer);

        verify(serializer).print("<Lap StartTime=\"2017-02-01T12:34:56.000Z\">");
        verify(serializer).print("<TotalTimeSeconds>651.0</TotalTimeSeconds>");
        verify(serializer).print("<DistanceMeters>350.0</DistanceMeters>");
        verify(serializer).print("<Calories>1534</Calories>");
        verify(serializer).print("<Intensity>Active</Intensity>");
        verify(serializer).print("<TriggerMethod>Manual</TriggerMethod>");
        verify(serializer).print("</Lap>");
    }
}