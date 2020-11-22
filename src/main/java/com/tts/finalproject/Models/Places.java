package com.tts.finalproject.Models;

public class Places {
    private Geometry geometry;

    private Opening_Hours opening_hours; 

    private String place_id;

    private String vicinity;

    public Places() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Opening_Hours getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(Opening_Hours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @Override
    public String toString() {
        return "Places [geometry=" + geometry + ", opening_hours=" + opening_hours + ", place_id=" + place_id
                + ", vicinity=" + vicinity + "]";
    }

    
}
