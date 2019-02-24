package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.Skill;
import com.tracker.admin.repo.SkillRepo;
import com.tracker.admin.service.SkillService;

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
