package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.Location;


@Repository
public interface LocationRepo extends JpaRepository<Location, Long>{

}
