package com.tracker.demand.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.demand.model.ProjTrakr;
import com.tracker.demand.repository.TrackerRepository;
import com.tracker.demand.service.TrackerService;


@Service
@Transactional
public class TrackerServiceImpl implements TrackerService  {
	
	@Autowired
	private TrackerRepository trackerRepository;

	@Override
	public List<ProjTrakr> getAllProj(long id) {
		return trackerRepository.findAll();
		//return trackerRepository.getProjectsRepo(id);
		
	}

	@Override
	public ProjTrakr addProj(ProjTrakr s) {
		return trackerRepository.save(s);
	}

	@Override
	public void UpdateProj(ProjTrakr s) {
		 trackerRepository.save(s);
	}

	@Override
	public void deleteProj(long id) {
		 trackerRepository.deleteById(id);
	}

}