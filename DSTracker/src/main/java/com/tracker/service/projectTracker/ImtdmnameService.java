package com.tracker.service.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.AppleManager;

public interface ImtdmnameService {

	
	//get all apple l2 Manager	
	public List<AppleManager> getAllapplel2mgrName();
	
	public AppleManager addAppleL2Manager(AppleManager appleL2Manager);

	public void deleteAppleL2Manager(long id);


}
