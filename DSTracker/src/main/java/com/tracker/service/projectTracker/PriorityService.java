package com.tracker.service.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.Priority;

public interface PriorityService {

	Priority addPriority(Priority priority);

	List<Priority> getAllPriority();
	

}
