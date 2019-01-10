package com.tracker.repository.projectTracker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.Priority;
@Repository
public interface PriorityRepo extends JpaRepository<Priority, Long>{

}
