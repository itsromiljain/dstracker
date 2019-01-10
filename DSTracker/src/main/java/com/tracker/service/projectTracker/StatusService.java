package com.tracker.service.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.Status;

public interface StatusService {

	Status addStatus(Status status);

	List<Status> getAllDemandStatus();


	
}
