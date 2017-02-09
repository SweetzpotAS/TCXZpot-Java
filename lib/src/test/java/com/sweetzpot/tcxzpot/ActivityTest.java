package com.sweetzpot.tcxzpot;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.sweetzpot.tcxzpot.TCXDate.tcxDate;
import static java.util.Calendar.FEBRUARY;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActivityTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Lap lap = mock(Lap.class);
        List<Lap> laps = Arrays.asList(lap);
        Application application = mock(Application.class);
        when(application.tcxType()).thenCallRealMethod();

        Activity activity = new Activity(tcxDate(1, FEBRUARY, 2017, 12, 34, 56), laps,
                "Notes for this activity", application, Sport.RUNNING);
        activity.serialize(serializer);

        verify(serializer).print("<Activity Sport=\"Running\">");
        verify(serializer).print("<Id>2017-02-01T12:34:56.000Z</Id>");
        verify(lap).serialize(serializer);
        verify(serializer).print("<Notes>Notes for this activity</Notes>");
        verify(serializer).print("<Creator xsi:type=\"Application_t\">");
        verify(application).serialize(serializer);
        verify(serializer).print("</Creator>");
        verify(serializer).print("</Activity>");
    }

    @Test
    public void producesCorrectSerializationWithMissingArguments() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Lap lap = mock(Lap.class);
        List<Lap> laps = Arrays.asList(lap);

        Activity activity = new Activity(tcxDate(1, FEBRUARY, 2017, 12, 34, 56), laps,
                null, null, Sport.RUNNING);
        activity.serialize(serializer);

        verify(serializer).print("<Activity Sport=\"Running\">");
        verify(serializer).print("<Id>2017-02-01T12:34:56.000Z</Id>");
        verify(lap).serialize(serializer);
        verify(serializer).print("</Activity>");
    }
}