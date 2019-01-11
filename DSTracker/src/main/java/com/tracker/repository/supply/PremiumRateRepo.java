package com.tracker.repository.supply;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.model.supply.PremiumRate;

public interface PremiumRateRepo extends JpaRepository<PremiumRate, Long> {

}
