package com.tts.finalproject.Service;

import java.util.Arrays;
import java.util.List;

import com.tts.finalproject.Models.DistanceResponse;
import com.tts.finalproject.Models.GeocodingResponse;
import com.tts.finalproject.Models.Location;
import com.tts.finalproject.Models.PlacesRequest;
import com.tts.finalproject.Models.PlacesResponse;
import com.tts.finalproject.Models.Places;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MickyService {
    
    @Value("${geocoding_url}")
    public String geocodingUrl;
	
    @Value("${distance_url}")
    public String distanceUrl;
	
    @Value("${places_url1}")
    public String placesUrl1;
	
    @Value("${places_url2}")
    public String placesUrl2;
	
    @Value("${api_key}")
    public String googleApiKey;

    public List<Places> getMickys(PlacesRequest request){
        RestTemplate restTemplate = new RestTemplate();
        Location coords = this.getCoordinates(request.getAddress() + " " + request.getCity() + " " + request.getState());
        String url = placesUrl1 + coords.lat + "," + coords.lng + placesUrl2 + googleApiKey;
        PlacesResponse placesResponse = restTemplate.getForObject(url, PlacesResponse.class);
        List<Places> places = placesResponse.getResults();
        return places;
        
    }

    private Location getCoordinates(String description) {
        description = description.replace(" ", "+");
        String url = geocodingUrl + description + "&key=" + googleApiKey;
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        System.out.println("In getCoordinates" + response.results.get(0).geometry.location);
        return response.results.get(0).geometry.location;
    }

    public double getDistance(Location origin, Location destination) {
        String url = distanceUrl + "origins=" + origin.lat + "," + origin.lng 
        + "&destinations=" + destination.lat + "," + destination.lng + "&key=" + googleApiKey;
        RestTemplate restTemplate = new RestTemplate();
        DistanceResponse response = restTemplate.getForObject(url, DistanceResponse.class);
        return response.rows.get(0).elements.get(0).distance.value * 0.000621371;

}

// public List<Places> getNearbyMickys(PlacesRequest request){
//     List<Places> allBuses = this.getMickys();
//     List<Places> nearbyBuses = new ArrayList<>();
//     for(Bus bus : allBuses) {
//         Location busLocation = new Location();
//         busLocation.lat = bus.LATITUDE;
//         busLocation.lng = bus.LONGITUDE;
//         double latDistance = Double.parseDouble(busLocation.lat) - Double.parseDouble(personLocation.lat);
//         double lngDistance = Double.parseDouble(busLocation.lng) - Double.parseDouble(personLocation.lng);
//         if (Math.abs(latDistance) <= 0.02 && Math.abs(lngDistance) <= 0.02) {
//             double distance = getDistance(busLocation, personLocation);
//             if (distance <= 1) {
//                 bus.distance = (double) Math.round(distance * 100) / 100;
//                 nearbyBuses.add(bus);
//             }
//         }
//     }
//     Collections.sort(nearbyBuses, new BusComparator());
//     return nearbyBuses;
// }

public Location getUserLocation(PlacesRequest request){
    Location personLocation = this.getCoordinates(request.address + " " + request.city + " " + request.state);
    System.out.println(personLocation);
    return personLocation;

}

}
