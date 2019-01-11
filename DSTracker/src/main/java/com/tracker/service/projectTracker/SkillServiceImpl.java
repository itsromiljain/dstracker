package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.Skill;
import com.tracker.repository.projectTracker.SkillRepo;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillRepo skillRepo;
	
	@Override
	public Skill addSkill(Skill skill) {
		return skillRepo.save(skill);
	}

	@Override
	public List<Skill> getAllSkill() {
		return skillRepo.findAll();
	}
	
	

}
