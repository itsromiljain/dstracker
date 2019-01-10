package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.DemandType;
import com.tracker.repository.projectTracker.DemandTypeRepo;

@Service
@Transactional
public class DemandTypeServiceImpl implements DemandTypeService{

	@Autowired
	DemandTypeRepo demandTypeRepo;
	@Override
	public DemandType addDemandType(DemandType demandType) {
		// TODO Auto-generated method stub
		return demandTypeRepo.save(demandType);
	}
	@Override
	public List<DemandType> getAllDemadType() {
		// TODO Auto-generated method stub
		return demandTypeRepo.findAll();
	}

}
