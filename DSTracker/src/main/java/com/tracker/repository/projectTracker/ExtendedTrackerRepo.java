package com.tracker.repository.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.ProjTrakr;



public interface ExtendedTrackerRepo{
	public List<ProjTrakr> getProjectsRepo(long id);
	//public List<ProjTrakr> getDemandsRepo(long id);
}
