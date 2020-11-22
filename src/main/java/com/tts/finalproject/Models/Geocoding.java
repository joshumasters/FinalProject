package com.tts.finalproject.Models;

public class Geocoding {
    public Geometry geometry;

    public Geocoding() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Geocoding [geometry=" + geometry + "]";
    }

    
}
