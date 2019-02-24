package com.tracker.repository.supply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.supply.SupplyDtls;
@Repository
public interface SupplyRepository extends JpaRepository<SupplyDtls,Long> {

}
