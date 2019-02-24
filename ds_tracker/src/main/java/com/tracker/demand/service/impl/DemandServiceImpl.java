package com.tracker.demand.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.tracker.demand.model.DemandDetail;
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
	public DemandDetail getProjectById(long id) {
		return demandRepo.findById(id).get();
	}

	@Override
	public List<DemandDetail> getAllProjects() {
		return demandRepo.findAll();
	}

	@Override
	public DemandDetail addProject(DemandDetail tracker) {
		return demandRepo.save(tracker);
	}

	@Override
	public void updateProject(DemandDetail tracker) {
		demandRepo.save(tracker);
	}

	@Override
	public void deleteProject(long id) {
		demandRepo.deleteById(id);
	}

}