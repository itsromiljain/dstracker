package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.AppleManager;

public interface AppleManagerService {

	
	//get all apple l2 Manager	
	public List<AppleManager> getAllapplel2mgrName();
	
	public AppleManager addAppleL2Manager(AppleManager appleL2Manager);

	public void deleteAppleL2Manager(long id);


}
