package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.YrOfExp;
import com.tracker.admin.repo.YrOfExpRepo;
import com.tracker.admin.service.YrOfExpService;

@Service
@Transactional
public class YrOfExpServiceImpl implements YrOfExpService{
	@Autowired
	YrOfExpRepo yrOfExpRepo;

	@Override
	public YrOfExp addYrOfExp(YrOfExp yrOfExp) {
		// TODO Auto-generated method stub
		return yrOfExpRepo.save(yrOfExp);
	}

	@Override
	public List<YrOfExp> getAllyrOfExp() {
		// TODO Auto-generated method stub
		return yrOfExpRepo.findAll();
	}
	
	

}
