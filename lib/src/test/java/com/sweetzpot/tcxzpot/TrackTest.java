package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrackTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Trackpoint trackpoint = mock(Trackpoint.class);

        Track track = new Track(trackpoint);
        track.serialize(serializer);

        verify(serializer).print("<Track>");
        verify(trackpoint).serialize(serializer);
        verify(serializer).print("</Track>");
    }
}