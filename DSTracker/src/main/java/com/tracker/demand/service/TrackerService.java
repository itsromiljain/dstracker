package com.tracker.demand.service;

import java.util.List;
import java.util.Optional;

import com.tracker.demand.model.ProjTrakr;

public interface TrackerService {
	
	public List<ProjTrakr> getAllProj(long id);
	public ProjTrakr addProj(ProjTrakr s);
	public void UpdateProj(ProjTrakr s);
	public void deleteProj(long id);
}
