package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.DemandType;
import com.tracker.admin.repo.DemandTypeRepo;
import com.tracker.admin.service.DemandTypeService;

@Service
@Transactional
public class DemandTypeServiceImpl implements DemandTypeService{

	@Autowired
	DemandTypeRepo demandTypeRepo;

	@Override
	public DemandType addDemandType(DemandType demandType) {
		return demandTypeRepo.save(demandType);
	}
	@Override
	public List<DemandType> getAllDemadType() {
		return demandTypeRepo.findAll();
	}

}
