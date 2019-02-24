package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.Priority;
import com.tracker.admin.repo.PriorityRepo;
import com.tracker.admin.service.PriorityService;

@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {
	
	@Autowired
	PriorityRepo priorityRepo;
	
	@Override
	public Priority addPriority(Priority priority) {
		return priorityRepo.save(priority);
	}

	@Override
	public List<Priority> getAllPriority() {
		return priorityRepo.findAll();
	}

}
