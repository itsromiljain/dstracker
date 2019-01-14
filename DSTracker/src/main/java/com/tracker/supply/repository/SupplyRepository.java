package com.tracker.supply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.supply.model.SupplyDtls;
@Repository
public interface SupplyRepository extends JpaRepository<SupplyDtls,Long> {

}
