package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static com.sweetzpot.tcxzpot.Activities.activities;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActivitiesTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Activity activity = mock(Activity.class);

        activities(activity).serialize(serializer);

        verify(serializer).print("<Activities>");
        verify(activity).serialize(serializer);
        verify(serializer).print("</Activities>");
    }
}