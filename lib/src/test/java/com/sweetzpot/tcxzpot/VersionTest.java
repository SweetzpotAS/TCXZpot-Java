package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.builders.VersionBuilder.version;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VersionTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        version().major(5).minor(3).buildMajor(1).buildMinor(7).build().serialize(serializer);

        verify(serializer).print("<Version>");
        verify(serializer).print("<VersionMajor>5</VersionMajor>");
        verify(serializer).print("<VersionMinor>3</VersionMinor>");
        verify(serializer).print("<BuildMajor>1</BuildMajor>");
        verify(serializer).print("<BuildMinor>7</BuildMinor>");
        verify(serializer).print("</Version>");
    }
}