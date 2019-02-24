package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.Location;
import com.tracker.admin.repo.LocationRepo;
import com.tracker.admin.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationRepo locationRepo;

	@Override
	public Location addLocation(Location location) {
		return locationRepo.save(location);
	}

	@Override
	public List<Location> getAllLocation() {
		return locationRepo.findAll();
	}

}
