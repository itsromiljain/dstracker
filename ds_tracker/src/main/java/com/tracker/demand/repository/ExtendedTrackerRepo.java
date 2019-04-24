package com.tracker.demand.repository;

import java.util.List;

import com.tracker.entity.DemandDetail;


public interface ExtendedTrackerRepo{
	public List<DemandDetail> getProjectsRepo(long id);
	//public List<DemandDetail> getDemandsRepo(long id);
}
