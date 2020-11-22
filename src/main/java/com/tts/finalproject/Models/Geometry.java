package com.tts.finalproject.Models;

public class Geometry {
    public Location location;

    public Geometry() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Geometry [location=" + location + "]";
    }

    
}
