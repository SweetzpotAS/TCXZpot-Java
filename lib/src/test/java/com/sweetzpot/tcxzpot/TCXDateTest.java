package com.sweetzpot.tcxzpot;

import org.junit.Test;

import java.util.Calendar;

import static com.sweetzpot.tcxzpot.TCXDate.tcxDate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TCXDateTest {

    @Test
    public void producesCorrectSerialization() throws Exception {
        Serializer serializer = mock(Serializer.class);

        TCXDate tcxDate = tcxDate(10, Calendar.FEBRUARY, 2017, 16, 28, 33);
        tcxDate.serialize(serializer);

        verify(serializer).print("2017-02-10T16:28:33.000Z");
    }
}