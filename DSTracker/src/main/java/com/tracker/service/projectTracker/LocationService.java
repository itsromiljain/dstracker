package com.tracker.service.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.Location;

public interface LocationService {

	Location addLocation(Location location);

	List<Location> getAllLocation();

}
