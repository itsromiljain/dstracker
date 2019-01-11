package com.tracker.service.supply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.supply.PremiumRate;
import com.tracker.repository.supply.PremiumRateRepo;

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
