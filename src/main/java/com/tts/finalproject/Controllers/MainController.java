package com.tts.finalproject.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.tts.finalproject.Models.Location;
import com.tts.finalproject.Models.Places;
import com.tts.finalproject.Models.PlacesRequest;
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
        ArrayList<Places> forRemoval = new ArrayList<>();
        for (Places place : places) {    
           if(place.getOpening_hours() == null) {
               forRemoval.add(place);
           }
        }
        System.out.println("~~~REMOVING~~~");
        for (Places place : forRemoval) {
            System.out.println(place.getName().toString());
        }
        places.removeAll(forRemoval);
    

        Location userLocation = mickyService.getUserLocation(request);
        for (Places place : places){
            place.setDistance(mickyService.getDistance(userLocation, place.getGeometry().getLocation()));
        }
        model.addAttribute("places", places);
        model.addAttribute("request", request);  
        model.addAttribute("userLocation", userLocation);  
        return "display";
    }
    
}
