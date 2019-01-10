package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.Priority;
import com.tracker.repository.projectTracker.PriorityRepo;

@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {
	
@Autowired
PriorityRepo priorityRepo;
	
	@Override
	public Priority addPriority(Priority priority) {
		// TODO Auto-generated method stub
		return priorityRepo.save(priority);
	}

	@Override
	public List<Priority> getAllPriority() {
		// TODO Auto-generated method stub
		return priorityRepo.findAll();
	}



	

}
