package com.sweetzpot.tcxzpot;

import java.util.Calendar;
import java.util.Date;

public class TCXDate {

    public static TCXDate tcxDate(int day, int month, int year, int hour, int minute, int second) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, day);
        instance.set(Calendar.HOUR_OF_DAY, hour);
        instance.set(Calendar.MINUTE, minute);
        instance.set(Calendar.SECOND, second);
        return new TCXDate(instance.getTime());
    }

    private final Date date;

    public TCXDate(Date date) {
        this.date = date;
    }
}
