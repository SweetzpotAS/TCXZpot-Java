package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntensityTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        Intensity.ACTIVE.serialize(serializer);

        verify(serializer).print("<Intensity>Active</Intensity>");
    }
}