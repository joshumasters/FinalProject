package com.tts.finalproject.Models;

import java.util.List;

public class PlacesResponse {
    private List<Places> results;

    public PlacesResponse() {
    }

    public List<Places> getResults() {
        return results;
    }

    public void setResults(List<Places> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PlacesResponse [results=" + results + "]";
    }

    
}
