package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.DelvryMgr;

@Repository
public interface DmnameRepository extends JpaRepository<DelvryMgr, Long> {

}