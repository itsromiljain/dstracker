package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.Imt;

@Repository
public interface ImtnameRepository extends JpaRepository<Imt, Long>,ExtendedTrackerRepo {

}
