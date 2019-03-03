package com.tracker.demand.service;

import java.util.List;

import com.tracker.demand.model.DemandDetail;

public interface DemandService {

	public DemandDetail getDemandById(String emailId, long demandId);
	
	public List<DemandDetail> getAllDemands();

	public List<DemandDetail> getDemandsByUser(String emailId);

	public List<DemandDetail> getAllArchivedDemands();

	public DemandDetail createDemand(String emailId, DemandDetail demandDetail);

	public void updateDemand(String emailId, DemandDetail demandDetail);

	public void archiveDemand(List<Long> demandIds);
}
