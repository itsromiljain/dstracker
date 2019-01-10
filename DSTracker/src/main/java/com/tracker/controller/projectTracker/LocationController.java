package com.tracker.controller.projectTracker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.AppleManager;
import com.tracker.model.projectTracker.Location;
import com.tracker.service.projectTracker.LocationService;

@RestController
public class LocationController {
	@Autowired
	LocationService locationService;
	
	
	@PostMapping("/addLocation")
	public Location location(@RequestBody Location location) {
		Location loc = locationService.addLocation(location);
		return loc;
	}
	
	
	@GetMapping("/getAllLocation")
	public ResponseEntity<List<Location>> getAllLocation() {

		List<Location> Location = new LinkedList<Location>();
		try {
			Location = locationService.getAllLocation();
			return ResponseEntity.ok().body(Location);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
