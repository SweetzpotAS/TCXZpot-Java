package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PositionTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        Position position = new Position(-34.4567, 16.00023);
        position.serialize(serializer);

        verify(serializer).print("<Position>");
        verify(serializer).print("<LatitudeDegrees>-34.4567</LatitudeDegrees>");
        verify(serializer).print("<LongitudeDegrees>16.00023</LongitudeDegrees>");
        verify(serializer).print("</Position>");
    }
}