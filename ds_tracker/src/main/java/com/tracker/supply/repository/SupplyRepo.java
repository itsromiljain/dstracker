package com.tracker.supply.repository;



import com.tracker.supply.model.SupplyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepo extends JpaRepository<SupplyDetail, Long> {

    @Query("Select supplyId, skill, supplyName from SupplyDetail")
    public List<Object[]> getSupplyDetails();
		
}


