package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.Status;

public interface StatusService {

	Status addStatus(Status status);

	List<Status> getAllDemandStatus();


	
}
