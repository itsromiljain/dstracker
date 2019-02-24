package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.SupplyStatus;
import com.tracker.admin.repo.SupplyStatusRepo;
import com.tracker.admin.service.SupplyStatusService;

@Service
@Transactional
public class SupplyStatusServiceImpl implements SupplyStatusService {
	@Autowired
	SupplyStatusRepo supplyStatusRepo;

	@Override
	public SupplyStatus addStatus(SupplyStatus supplyStatus) {
		return supplyStatusRepo.save(supplyStatus);
	}

	@Override
	public List<SupplyStatus> getAllSupplyStatus() {
		// TODO Auto-generated method stub
		return supplyStatusRepo.findAll();
	}

}
