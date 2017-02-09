package com.sweetzpot.tcxzpot;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TCXDate implements TCXSerializable {

    public static TCXDate tcxDate(int day, int month, int year, int hour, int minute, int second) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, day);
        instance.set(Calendar.HOUR_OF_DAY, hour);
        instance.set(Calendar.MINUTE, minute);
        instance.set(Calendar.SECOND, second);
        instance.set(Calendar.MILLISECOND, 0);
        return new TCXDate(instance.getTime());
    }

    private final Date date;

    public TCXDate(Date date) {
        this.date = date;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print(toString());
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return format.format(date);
    }
}
