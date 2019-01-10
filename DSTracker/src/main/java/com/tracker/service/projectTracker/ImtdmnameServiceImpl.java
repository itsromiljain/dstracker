package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.AppleManager;
import com.tracker.repository.projectTracker.AppleManagerRepo;


@Service
@Transactional
public class ImtdmnameServiceImpl implements ImtdmnameService {


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
