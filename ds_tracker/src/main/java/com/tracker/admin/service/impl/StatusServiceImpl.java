package com.tracker.admin.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.DemandStatus;
import com.tracker.admin.repo.StatusRepo;
import com.tracker.admin.service.StatusService;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {
	@Autowired
	StatusRepo statusRepo;

	@Override
	public DemandStatus addStatus(DemandStatus status) {
		return statusRepo.save(status);
	}

	@Override
	public List<DemandStatus> getAllDemandStatus() {
		return statusRepo.findAll();
	}

}
