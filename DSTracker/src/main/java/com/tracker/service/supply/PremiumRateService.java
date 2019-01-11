package com.tracker.service.supply;

import java.util.List;

import com.tracker.model.supply.PremiumRate;

public interface PremiumRateService {

	PremiumRate addPremiumRate(PremiumRate premiumRate);

	List<PremiumRate> getAllPremiumRate();

}
