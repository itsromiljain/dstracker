package com.tracker.supply.repository;



import com.tracker.supply.model.SupplyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyDetail, Long> {
		
}


