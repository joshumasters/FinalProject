package com.tts.finalproject.Models;

public class Opening_Hours {
    private String open_now;

    public Opening_Hours() {
    }

    public String getOpen_now() {
        return open_now;
    }

    public void setOpen_now(String open_now) {
        this.open_now = open_now;
    }

    @Override
    public String toString() {
        return "Opening_Hours [open_now=" + open_now + "]";
    }

    
}
