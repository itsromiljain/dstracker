package com.tracker.demand.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.tracker.demand.model.ProjectTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.demand.repository.ProjectTrackerRepository;
import com.tracker.demand.service.TrackerService;


@Service
@Transactional
public class TrackerServiceImpl implements TrackerService  {
	
	@Autowired
	private ProjectTrackerRepository projectTrackerRepository;

	@Override
	public ProjectTracker getProjectById(long id) {
		return projectTrackerRepository.findById(id).get();

	}

	@Override
	public List<ProjectTracker> getAllProjects() {
		return projectTrackerRepository.findAll();
	}

	@Override
	public ProjectTracker addProject(ProjectTracker tracker) {
		return projectTrackerRepository.save(tracker);
	}

	@Override
	public void updateProject(ProjectTracker tracker) {
		projectTrackerRepository.save(tracker);
	}

	@Override
	public void deleteProject(long id) {
		projectTrackerRepository.deleteById(id);
	}

}