package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Build build = mock(Build.class);

        Application application = new Application("SweetZpot Rowing", build, "en", "123-45678-90");
        application.serialize(serializer);

        verify(serializer).print("<Name>SweetZpot Rowing</Name>");
        verify(build).serialize(serializer);
        verify(serializer).print("<LangID>en</LangID>");
        verify(serializer).print("<PartNumber>123-45678-90</PartNumber>");
    }
}