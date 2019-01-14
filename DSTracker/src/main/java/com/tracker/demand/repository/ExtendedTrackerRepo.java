package com.tracker.demand.repository;

import java.util.List;

import com.tracker.demand.model.ProjTrakr;



public interface ExtendedTrackerRepo{
	public List<ProjTrakr> getProjectsRepo(long id);
	//public List<ProjTrakr> getDemandsRepo(long id);
}
