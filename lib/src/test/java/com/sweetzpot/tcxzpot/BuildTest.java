package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BuildTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Version version = mock(Version.class);
        BuildType type = BuildType.ALPHA;

        Build build = new Build(version, type, "2017-02-09T13:14:45.123Z");
        build.serialize(serializer);

        verify(serializer).print("<Build>");
        verify(version).serialize(serializer);
        verify(serializer).print("<Type>Alpha</Type>");
        verify(serializer).print("<Time>2017-02-09T13:14:45.123Z</Time>");
        verify(serializer).print("</Build>");
    }

    @Test
    public void producesCorrectSerializationWithMissingParameters() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Version version = mock(Version.class);

        Build build = new Build(version, null, null);
        build.serialize(serializer);

        verify(serializer).print("<Build>");
        verify(version).serialize(serializer);
        verify(serializer).print("</Build>");
        verifyNoMoreInteractions(serializer);
    }
}