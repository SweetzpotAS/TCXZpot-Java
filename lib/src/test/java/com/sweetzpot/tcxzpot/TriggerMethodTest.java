package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TriggerMethodTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        TriggerMethod.MANUAL.serialize(serializer);

        verify(serializer).print("<TriggerMethod>Manual</TriggerMethod>");
    }
}