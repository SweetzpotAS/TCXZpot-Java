package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeviceTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Version version = mock(Version.class);

        Device device = new Device("BreathZpot", 256, 1298745, version);
        device.serialize(serializer);

        verify(serializer).print("<Name>BreathZpot</Name>");
        verify(serializer).print("<UnitId>256</UnitId>");
        verify(serializer).print("<ProductID>1298745</ProductID>");
        verify(version).serialize(serializer);
    }
}