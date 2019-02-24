package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.admin.model.PremiumRate;

public interface PremiumRateRepo extends JpaRepository<PremiumRate, Long> {

}
