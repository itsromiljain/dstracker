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
	private AppleManagerRepo appleL2ManagerRepository;





//get all apple L2 Manager
	@Override
	public List<AppleManager> getAllapplel2mgrName() {
		return appleL2ManagerRepository.findAll();
	}

	@Override
	public AppleManager addAppleL2Manager(AppleManager appleL2Manager) {
		// TODO Auto-generated method stub
		return appleL2ManagerRepository.save(appleL2Manager);
	}

	@Override
	public void deleteAppleL2Manager(long id) {
		appleL2ManagerRepository.deleteById(id);
		
	}


	

		
	

}
