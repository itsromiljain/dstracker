package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.admin.model.SubmittedBy;

public interface SubmittedByRepo extends JpaRepository<SubmittedBy, Long>{

}
