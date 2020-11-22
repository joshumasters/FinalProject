package com.tts.finalproject.Models;

public class PlacesRequest {
    public String address;
    public String city;
    public String state;

   public PlacesRequest() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PlacesRequest [address=" + address + ", city=" + city + ", state=" + state + "]";
    }

    

    

    
}
