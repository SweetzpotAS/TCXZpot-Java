package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.builders.ApplicationBuilder.application;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Build build = mock(Build.class);

        application("SweetZpot Rowing").withBuild(build)
                .withLanguageID("en")
                .withPartNumber("123-45678-90")
                .build().serialize(serializer);

        verify(serializer).print("<Name>SweetZpot Rowing</Name>");
        verify(build).serialize(serializer);
        verify(serializer).print("<LangID>en</LangID>");
        verify(serializer).print("<PartNumber>123-45678-90</PartNumber>");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingName() throws Exception {
        application(null).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingBuild() throws Exception {
        application("SweetZpot Rowing").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingLanguage() throws Exception {
        application("SweetZpot Rowing").withBuild(mock(Build.class)).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMissingPartNumber() throws Exception {
        application("SweetZpot Rowing").withBuild(mock(Build.class)).withLanguageID("en").build();
    }
}