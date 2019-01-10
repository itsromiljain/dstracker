package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.AppleManager;

@Repository
public interface AppleManagerRepo extends JpaRepository<AppleManager, Long>{

}
