package com.example.mslocation.controller;

import com.example.mslocation.entity.Location;
import com.example.mslocation.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    // Add a location
    @PostMapping
    public Location addlocation(@RequestBody Location location){
        //if no date/time, then we force it
        if(location.getDateHeure() == null) {
            location.setDateHeure(java.time.LocalDateTime.now());
        }
        return locationRepository.save(location);
    }

    //Read all
    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    //Read by userid
    @GetMapping("/user/{id}")
    public List<Location> getLocationsByUserId(@PathVariable Long id){
        return locationRepository.findByUserId(id);
    }
}
