package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.Priority;

public interface PriorityService {

	Priority addPriority(Priority priority);

	List<Priority> getAllPriority();
	

}
