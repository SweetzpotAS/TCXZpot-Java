package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.Sport.RUNNING;
import static com.sweetzpot.tcxzpot.TCXDate.tcxDate;
import static com.sweetzpot.tcxzpot.builders.ActivityBuilder.activity;
import static java.util.Calendar.FEBRUARY;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ActivityTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Lap lap = mock(Lap.class);
        Notes notes = mock(Notes.class);
        Application application = mock(Application.class);
        when(application.tcxType()).thenCallRealMethod();

        activity(RUNNING).withID(tcxDate(1, FEBRUARY, 2017, 12, 34, 56))
                .withLaps(lap)
                .withNotes(notes)
                .withCreator(application)
                .build().serialize(serializer);

        verify(serializer).print("<Activity Sport=\"Running\">");
        verify(serializer).print("<Id>2017-02-01T12:34:56.000Z</Id>");
        verify(lap).serialize(serializer);
        verify(notes).serialize(serializer);
        verify(serializer).print("<Creator xsi:type=\"Application_t\">");
        verify(application).serialize(serializer);
        verify(serializer).print("</Creator>");
        verify(serializer).print("</Activity>");
    }

    @Test
    public void producesCorrectSerializationWithMissingArguments() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Lap lap = mock(Lap.class);

        activity(RUNNING).withID(tcxDate(1, FEBRUARY, 2017, 12, 34, 56))
                .withLaps(lap)
                .build().serialize(serializer);

        verify(serializer).print("<Activity Sport=\"Running\">");
        verify(serializer).print("<Id>2017-02-01T12:34:56.000Z</Id>");
        verify(lap).serialize(serializer);
        verify(serializer).print("</Activity>");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingSport() throws Exception {
        activity(null).withID(tcxDate(1, FEBRUARY, 2017, 12, 34, 56))
                .withLaps(mock(Lap.class))
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingID() throws Exception {
        activity(RUNNING)
                .withLaps(mock(Lap.class))
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingLaps() throws Exception {
        activity(RUNNING).withID(tcxDate(1, FEBRUARY, 2017, 12, 34, 56))
                .build();
    }
}