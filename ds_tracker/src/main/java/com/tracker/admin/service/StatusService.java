package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.DemandStatus;

public interface StatusService {

	DemandStatus addStatus(DemandStatus status);

	List<DemandStatus> getAllDemandStatus();


	
}
