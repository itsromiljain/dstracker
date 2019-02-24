package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.AppleManager;

public interface AppleManagerService {

	public List<AppleManager> getAppleManagers();
	
	public AppleManager addAppleManager(AppleManager appleManager);

	public void deleteAppleManager(long id);


}
