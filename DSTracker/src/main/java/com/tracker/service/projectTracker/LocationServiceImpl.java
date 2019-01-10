package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.Location;
import com.tracker.repository.projectTracker.LocationRepo;
@Service
@Transactional
public class LocationServiceImpl implements LocationService{
@Autowired
LocationRepo locationRepo;
	@Override
	public Location addLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}
	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return locationRepo.findAll();
	}

}
