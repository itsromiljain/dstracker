package com.tracker.admin.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.Status;
import com.tracker.admin.repo.StatusRepo;
import com.tracker.admin.service.StatusService;

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
