package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.builders.DeviceBuilder.device;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeviceTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Version version = mock(Version.class);

        device("BreathZpot").withUnitId(256)
                .withProductId(1298745)
                .withVersion(version)
                .build().serialize(serializer);

        verify(serializer).print("<Name>BreathZpot</Name>");
        verify(serializer).print("<UnitId>256</UnitId>");
        verify(serializer).print("<ProductID>1298745</ProductID>");
        verify(version).serialize(serializer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingName() throws Exception {
        device(null).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingUnitId() throws Exception {
        device("BreathZpot").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingProductId() throws Exception {
        device("BreathZpot").withUnitId(256).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingVersion() throws Exception {
        device("BreathZpot").withUnitId(256)
                .withProductId(1298745).build();

    }
}