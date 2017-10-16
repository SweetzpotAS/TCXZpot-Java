package com.sweetzpot.tcxzpot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.sweetzpot.tcxzpot.Intensity.ACTIVE;
import static com.sweetzpot.tcxzpot.TCXDate.tcxDate;
import static com.sweetzpot.tcxzpot.TriggerMethod.MANUAL;
import static com.sweetzpot.tcxzpot.builders.LapBuilder.aLap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class LapTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        HeartRate averageHeartRate = mock(HeartRate.class);
        HeartRate maximumHeartRate = mock(HeartRate.class);
        TCXExtension extension = mock(TCXExtension.class);
        Cadence cadence = mock(Cadence.class);
        Track track = mock(Track.class);
        List<Track> tracks = Arrays.asList(track);
        Notes notes = mock(Notes.class);

        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withDistance(350)
                .withMaximumSpeed(10)
                .withCalories(1534)
                .withAverageHeartRate(averageHeartRate)
                .withMaximumHeartRate(maximumHeartRate)
                .withIntensity(ACTIVE)
                .withCadence(cadence)
                .withTriggerMethod(MANUAL)
                .withTracks(tracks)
                .withNotes(notes)
                .withExtensions(extension)
                .build().serialize(serializer);

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
        verify(notes).serialize(serializer);
        verify(serializer).print("<Extensions>");
        verify(extension).serialize(serializer);
        verify(serializer).print("</Extensions>");
        verify(serializer).print("</Lap>");
    }

    @Test
    public void producesCorrectSerializationWithMissingArguments() throws Exception {
        Serializer serializer = mock(Serializer.class);

        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withDistance(350)
                .withCalories(1534)
                .withIntensity(ACTIVE)
                .withTriggerMethod(MANUAL)
                .build().serialize(serializer);

        verify(serializer).print("<Lap StartTime=\"2017-02-01T12:34:56.000Z\">");
        verify(serializer).print("<TotalTimeSeconds>651.0</TotalTimeSeconds>");
        verify(serializer).print("<DistanceMeters>350.0</DistanceMeters>");
        verify(serializer).print("<Calories>1534</Calories>");
        verify(serializer).print("<Intensity>Active</Intensity>");
        verify(serializer).print("<TriggerMethod>Manual</TriggerMethod>");
        verify(serializer).print("</Lap>");
        verifyNoMoreInteractions(serializer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingStartTime() throws Exception {
        aLap(null)
                .withTotalTime(651)
                .withDistance(350)
                .withCalories(1534)
                .withIntensity(ACTIVE)
                .withTriggerMethod(MANUAL)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingTotalTime() throws Exception {
        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withDistance(350)
                .withCalories(1534)
                .withIntensity(ACTIVE)
                .withTriggerMethod(MANUAL)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingDistance() throws Exception {
        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withCalories(1534)
                .withIntensity(ACTIVE)
                .withTriggerMethod(MANUAL)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingCalories() throws Exception {
        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withDistance(350)
                .withIntensity(ACTIVE)
                .withTriggerMethod(MANUAL)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingIntensity() throws Exception {
        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withDistance(350)
                .withCalories(1534)
                .withTriggerMethod(MANUAL)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingTriggerMethod() throws Exception {
        aLap(tcxDate(1, Calendar.FEBRUARY, 2017, 12, 34, 56))
                .withTotalTime(651)
                .withDistance(350)
                .withCalories(1534)
                .withIntensity(ACTIVE)
                .build();
    }
}