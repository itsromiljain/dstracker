package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.tracker.admin.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.repo.ExperienceRepo;
import com.tracker.admin.service.ExperienceService;

@Service
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	ExperienceRepo experienceRepo;

	@Override
	public Experience addYrOfExp(Experience experience) {
		return experienceRepo.save(experience);
	}

	@Override
	public List<Experience> getAllyrOfExp() {
		return experienceRepo.findAll();
	}
	
	

}
