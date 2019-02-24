package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.AppleManager;
import com.tracker.admin.repo.AppleManagerRepo;
import com.tracker.admin.service.AppleManagerService;


@Service
@Transactional
public class AppleManagerServiceImpl implements AppleManagerService {


	@Autowired
	private AppleManagerRepo appleLManagerRepo;


	@Override
	public List<AppleManager> getAppleManagers() {
		return appleLManagerRepo.findAll();
	}

	@Override
	public AppleManager addAppleManager(AppleManager appleL2Manager) {
		// TODO Auto-generated method stub
		return appleLManagerRepo.save(appleL2Manager);
	}

	@Override
	public void deleteAppleManager(long id) {
		appleLManagerRepo.deleteById(id);
		
	}

}
