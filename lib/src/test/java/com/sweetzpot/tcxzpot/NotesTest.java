package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.Notes.notes;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotesTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        notes("Sample notes").serialize(serializer);

        verify(serializer).print("<Notes>Sample notes</Notes>");
    }
}