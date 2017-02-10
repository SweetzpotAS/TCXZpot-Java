package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.HeartRate.bpm;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HeartRateTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        bpm(82).serialize(serializer);

        verify(serializer).print("<Value>82</Value>");
    }
}