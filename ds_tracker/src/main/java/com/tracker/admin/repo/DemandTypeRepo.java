package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.DemandType;


@Repository
public interface DemandTypeRepo extends JpaRepository<DemandType, Long>{

}
