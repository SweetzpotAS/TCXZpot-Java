package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.builders.PositionBuilder.aPosition;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PositionTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        aPosition().withLatitude(-34.4567)
                .withLongitude(16.00023)
                .build().serialize(serializer);

        verify(serializer).print("<Position>");
        verify(serializer).print("<LatitudeDegrees>-34.4567</LatitudeDegrees>");
        verify(serializer).print("<LongitudeDegrees>16.00023</LongitudeDegrees>");
        verify(serializer).print("</Position>");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingLatitude() throws Exception {
        aPosition().withLongitude(1.0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingLongitude() throws Exception {
        aPosition().withLatitude(1.0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLatitudeIsUnderRange() throws Exception {
        aPosition().withLatitude(-1000).withLongitude(0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLatitudeIsAboveRange() throws Exception {
        aPosition().withLatitude(1000).withLongitude(0).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLongitudeIsUnderRange() throws Exception {
        aPosition().withLatitude(0).withLongitude(-1000).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLongitudeIsAboveRange() throws Exception {
        aPosition().withLatitude(0).withLongitude(1000).build();
    }
}