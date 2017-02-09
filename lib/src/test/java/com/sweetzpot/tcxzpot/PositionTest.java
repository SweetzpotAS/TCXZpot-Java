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
}