package com.tracker.demand.repository;

import java.util.List;

import com.tracker.demand.model.ProjectTracker;


public interface ExtendedTrackerRepo{
	public List<ProjectTracker> getProjectsRepo(long id);
	//public List<ProjectTracker> getDemandsRepo(long id);
}
