package com.tracker.service.projectTracker;

import java.util.List;
import java.util.Optional;

import com.tracker.model.projectTracker.ProjTrakr;

public interface TrackerService {
	
	public List<ProjTrakr> getAllProj(long id);
	public ProjTrakr addProj(ProjTrakr s);
	public void UpdateProj(ProjTrakr s);
	public void deleteProj(long id);
}
