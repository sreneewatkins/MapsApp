package com.tts.mapsapp.controller;

import com.tts.mapsapp.model.Location;
import com.tts.mapsapp.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MapController {

    private MapService mapService;
//    private Logger logger = LoggerFactory.getLogger(MapController.class);

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }
/*
    @GetMapping("/home")
    public String getDefaultMap() {

        Location location = new Location();
        location.setCity("Dallas");
        location.setState("Texas");
        mapService.addCoordinates(location);
        System.out.println(location);
        log.info("This is my location: {}", location);

        return "index.html";
    }
*/
    /*
    Now let's update the controller to handle this form submission. Change
    the existing MapController method to add a blank Location object to the
    model.
     */

    @GetMapping("/home")
    public String getDefaultMap(Model model) {
        model.addAttribute(new Location());
        return "index.html";
    }

    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute("location", location);
        return "index.html";
    }


}//end MapController class
