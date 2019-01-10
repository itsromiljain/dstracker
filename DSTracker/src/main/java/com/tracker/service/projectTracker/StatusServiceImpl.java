package com.tracker.service.projectTracker;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.Status;
import com.tracker.repository.projectTracker.StatusRepo;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {
	@Autowired
	StatusRepo statusRepo;

	@Override
	public Status addStatus(Status status) {
		// TODO Auto-generated method stub
		return statusRepo.save(status);
	}

	@Override
	public List<Status> getAllDemandStatus() {
		// TODO Auto-generated method stub
		return statusRepo.findAll();
	}


	
	

	

}
