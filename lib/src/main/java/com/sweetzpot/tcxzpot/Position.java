package com.sweetzpot.tcxzpot;

public class Position implements TCXSerializable {

    private final double latitude;
    private final double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Position>");
        serializer.print("<LatitudeDegrees>" + latitude + "</LatitudeDegrees>");
        serializer.print("<LongitudeDegrees>" + longitude + "</LongitudeDegrees>");
        serializer.print("</Position>");
    }
}
