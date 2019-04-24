package com.tracker.demand.service;

import com.tracker.demand.pojo.DemandTO;

import java.util.List;

public interface DemandService {

	public DemandTO getDemandById(String emailId, String demandId);
	
	public List<DemandTO> getAllDemands();

	public List<DemandTO> getDemandsByUser(String emailId);

	public List<DemandTO> getAllArchivedDemands();

	public DemandTO createDemand(String emailId, DemandTO demandTO);

	public void updateDemand(String emailId, DemandTO demandTO);

	public void archiveDemand(List<String> demandIds);
}
