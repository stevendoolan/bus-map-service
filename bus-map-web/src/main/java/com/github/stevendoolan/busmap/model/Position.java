package com.github.stevendoolan.busmap.model;

/**
 * Created by Steven Doolan on 22/05/2016.
 */
public class Position {

    private String routeId;
    private float longitude;
    private float latitude;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
