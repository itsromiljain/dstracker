package com.tracker.demand.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.tracker.demand.model.ProjectTracker;

@Repository
public interface ProjectTrackerRepository extends JpaRepository<ProjectTracker, Long> {

}

