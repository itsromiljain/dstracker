package com.tracker.admin.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.Priority;
@Repository
public interface PriorityRepo extends JpaRepository<Priority, Long>{

}
