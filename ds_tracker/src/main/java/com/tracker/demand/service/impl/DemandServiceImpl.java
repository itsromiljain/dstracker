package com.tracker.demand.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.tracker.demand.model.DemandDetail;
import com.tracker.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.demand.repository.DemandRepo;
import com.tracker.demand.service.DemandService;


@Service
@Transactional
public class DemandServiceImpl implements DemandService {
	
	@Autowired
	private DemandRepo demandRepo;

	@Override
	public DemandDetail getDemandById(String emailId, long demandId) {
		Optional<DemandDetail> optDemandDetail = demandRepo.findById(emailId, demandId);
		return optDemandDetail.isPresent()? optDemandDetail.get():null;
	}

	@Override
	public List<DemandDetail> getAllDemands() {
		return demandRepo.findAll();
	}

	@Override
	public List<DemandDetail> getDemandsByUser(String emailId) {
		return demandRepo.findById(emailId);
	}

	@Override
	public List<DemandDetail> getAllArchivedDemands() {
		return demandRepo.findAllArchivedDemands();
	}

	@Override
	public DemandDetail createDemand(String emailId, DemandDetail demandDetail) {
		User user = new User();
		user.setEmailId(emailId);
		demandDetail.setSubmittedBy(user);
		demandDetail.setCreatedBy(user);
		// Make sure isArchived set to 0 while creating demand
		return demandRepo.save(demandDetail);
	}

	@Override
	public void updateDemand(String emailId, DemandDetail demandDetail) {
		User user = new User();
		user.setEmailId(emailId);
		demandDetail.setSubmittedBy(user);
		demandDetail.setCreatedBy(user);
		demandRepo.save(demandDetail);
	}

	@Override
	public void archiveDemand(List<Long> demandIds) {
		// set isArchived as 1
		demandRepo.archiveDemand(demandIds);
	}

}