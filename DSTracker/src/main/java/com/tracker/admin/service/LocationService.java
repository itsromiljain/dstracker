package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.Location;

public interface LocationService {

	Location addLocation(Location location);

	List<Location> getAllLocation();

}
