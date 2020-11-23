package com.tts.finalproject.Controllers;

import java.util.List;

import com.tts.finalproject.Models.Location;
import com.tts.finalproject.Models.Places;
import com.tts.finalproject.Models.PlacesRequest;
import com.tts.finalproject.Models.PlacesResponse;
import com.tts.finalproject.Service.MickyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    MickyService mickyService;

    @GetMapping("/")
    public String getPage(Model model){
        model.addAttribute("request", new PlacesRequest());
        return "index";
    }
	
    @PostMapping("/")
    public String getMickys(PlacesRequest request, Model model) {
        List<Places> places = mickyService.getMickys(request);
        Location userLocation = mickyService.getUserLocation(request);
        for (Places place : places){
            place.setDistance(mickyService.getDistance(userLocation, place.getGeometry().getLocation()));
            System.out.println(place.getDistance());
        }
        model.addAttribute("places", places);
        model.addAttribute("request", request);  
        model.addAttribute("userLocation", userLocation);  
        return "display";
    }
    
}
