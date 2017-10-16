package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.builders.TrainingCenterDatabaseBuilder.trainingCenterDatabase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class TrainingCenterDatabaseTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Activities activities = mock(Activities.class);
        TCXExtension extension = mock(TCXExtension.class);
        Device device = mock(Device.class);
        when(device.tcxType()).thenCallRealMethod();

        trainingCenterDatabase().withActivities(activities)
                .withAuthor(device)
                .withExtensions(extension)
                .build().serialize(serializer);

        verify(serializer).print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        verify(serializer).print("<TrainingCenterDatabase\n" +
                "  xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd\"\n" +
                "  xmlns=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2\"\n" +
                "  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        verify(activities).serialize(serializer);
        verify(serializer).print("<Author xsi:type=\"Device_t\">");
        verify(device).serialize(serializer);
        verify(serializer).print("</Author>");
        verify(serializer).print("<Extensions>");
        verify(extension).serialize(serializer);
        verify(serializer).print("</Extensions>");
        verify(serializer).print("</TrainingCenterDatabase>");
    }

    @Test
    public void producesCorrectSerializationWithMissingArguments() throws Exception {
        Serializer serializer = mock(Serializer.class);

        trainingCenterDatabase().build().serialize(serializer);

        verify(serializer).print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        verify(serializer).print("<TrainingCenterDatabase\n" +
                "  xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd\"\n" +
                "  xmlns=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2\"\n" +
                "  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        verify(serializer).print("</TrainingCenterDatabase>");
        verifyNoMoreInteractions(serializer);
    }
}