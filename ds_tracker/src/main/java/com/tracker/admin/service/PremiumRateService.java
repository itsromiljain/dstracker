package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.PremiumRate;

public interface PremiumRateService {

	PremiumRate addPremiumRate(PremiumRate premiumRate);

	List<PremiumRate> getAllPremiumRate();

}
