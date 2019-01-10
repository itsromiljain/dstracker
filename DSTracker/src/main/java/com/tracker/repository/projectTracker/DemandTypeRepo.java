package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.DemandType;


@Repository
public interface DemandTypeRepo extends JpaRepository<DemandType, Long>{

}
