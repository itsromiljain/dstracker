package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.PremiumRate;
import com.tracker.admin.repo.PremiumRateRepo;
import com.tracker.admin.service.PremiumRateService;

@Service
@Transactional
public class PremiumRateServiceImpl implements PremiumRateService {

	@Autowired
	PremiumRateRepo premiumRateRepo;
	
	@Override
	public PremiumRate addPremiumRate(PremiumRate premiumRate) {		
		return premiumRateRepo.save(premiumRate);
	}
	
	@Override
	public List<PremiumRate> getAllPremiumRate() {		
		return premiumRateRepo.findAll();
	}

	

}
