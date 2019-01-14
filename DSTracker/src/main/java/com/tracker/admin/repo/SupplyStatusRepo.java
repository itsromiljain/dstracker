package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.SupplyStatus;

@Repository
public interface SupplyStatusRepo extends JpaRepository<SupplyStatus, Long>{

}
