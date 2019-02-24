package com.tracker.demand.service;

import java.util.List;

import com.tracker.demand.model.ProjectTracker;

public interface TrackerService {

	public ProjectTracker getProjectById(long id);
	
	public List<ProjectTracker> getAllProjects();

	public ProjectTracker addProject(ProjectTracker s);

	public void updateProject(ProjectTracker s);

	public void deleteProject(long id);
}
