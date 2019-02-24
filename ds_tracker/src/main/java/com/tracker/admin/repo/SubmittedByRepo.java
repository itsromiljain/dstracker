package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.admin.model.SubmittedBy;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmittedByRepo extends JpaRepository<SubmittedBy, Long>{

}
