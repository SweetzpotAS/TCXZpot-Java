package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BuildTypeTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        BuildType.RELEASE.serialize(serializer);

        verify(serializer).print("<Type>Release</Type>");
    }
}