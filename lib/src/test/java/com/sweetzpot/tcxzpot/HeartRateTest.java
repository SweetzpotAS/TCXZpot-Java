package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HeartRateTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        HeartRate heartRate = new HeartRate(82);
        heartRate.serialize(serializer);

        verify(serializer).print("<Value>82</Value>");
    }
}