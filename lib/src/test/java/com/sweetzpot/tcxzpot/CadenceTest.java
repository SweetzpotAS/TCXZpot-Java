package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.Cadence.cadence;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CadenceTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        cadence(56).serialize(serializer);

        verify(serializer).print("<Cadence>56</Cadence>");
    }
}