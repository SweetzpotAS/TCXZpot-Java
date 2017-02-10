package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.Position;

public class PositionBuilder {

    public static PositionBuilder aPosition() {
        return new PositionBuilder();
    }

    private PositionBuilder() {}

    private Double latitude;
    private Double longitude;

    public PositionBuilder withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public PositionBuilder withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Position build() {
        validateArguments();
        return new Position(latitude, longitude);
    }

    private void validateArguments() {
        if(this.latitude == null) {
            throw new IllegalArgumentException("Position must have a latitude");
        }
        if(this.longitude == null) {
            throw new IllegalArgumentException("Position must have a longitude");
        }
        if(latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be in range [-90, 90]");
        }
        if(longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be in range [-180, 180]");
        }
    }
}
