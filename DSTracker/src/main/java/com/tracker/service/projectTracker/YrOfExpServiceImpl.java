package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.YrOfExp;
import com.tracker.repository.projectTracker.YrOfExpRepo;

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
