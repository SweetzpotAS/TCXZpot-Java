package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SensorStateTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        SensorState.PRESENT.serialize(serializer);

        verify(serializer).print("<SensorState>Present</SensorState>");
    }
}