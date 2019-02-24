package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.ProjTrakr;



@Repository
public interface TrackerRepository extends JpaRepository<ProjTrakr, Long>,ExtendedTrackerRepo {

}

