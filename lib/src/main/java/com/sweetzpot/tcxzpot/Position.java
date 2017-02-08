package com.sweetzpot.tcxzpot;

public class Position implements TCXSerializable {

    private final double latitude;
    private final double longitude;

    public Position(double latitude, double longitude) {
        validateArguments(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void validateArguments(double latitude, double longitude) {
        if(latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be in range [-90, 90]");
        }
        if(longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be in range [-180, 180]");
        }
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Position>");
        serializer.print("<LatitudeDegrees>" + latitude + "</LatitudeDegrees>");
        serializer.print("<LongitudeDegrees>" + longitude + "</LongitudeDegrees>");
        serializer.print("</Position>");
    }
}
