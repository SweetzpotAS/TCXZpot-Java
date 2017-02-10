package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.Position.position;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PositionTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        position(-34.4567, 16.00023).serialize(serializer);

        verify(serializer).print("<Position>");
        verify(serializer).print("<LatitudeDegrees>-34.4567</LatitudeDegrees>");
        verify(serializer).print("<LongitudeDegrees>16.00023</LongitudeDegrees>");
        verify(serializer).print("</Position>");
    }


    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLatitudeIsUnderRange() throws Exception {
        position(-1000, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLatitudeIsAboveRange() throws Exception {
        position(1000, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLongitudeIsUnderRange() throws Exception {
        position(0, -1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfLongitudeIsAboveRange() throws Exception {
        position(0, 1000);
    }
}