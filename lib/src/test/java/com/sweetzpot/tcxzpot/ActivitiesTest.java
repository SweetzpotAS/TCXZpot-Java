package com.sweetzpot.tcxzpot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActivitiesTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);
        Activity activity = mock(Activity.class);

        Activities activities = new Activities(activity);
        activities.serialize(serializer);

        verify(serializer).print("<Activities>");
        verify(activity).serialize(serializer);
        verify(serializer).print("</Activities>");
    }
}