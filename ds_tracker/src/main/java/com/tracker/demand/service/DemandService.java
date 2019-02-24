package com.tracker.demand.service;

import java.util.List;

import com.tracker.demand.model.DemandDetail;

public interface DemandService {

	public DemandDetail getProjectById(long id);
	
	public List<DemandDetail> getAllProjects();

	public DemandDetail addProject(DemandDetail s);

	public void updateProject(DemandDetail s);

	public void deleteProject(long id);
}
