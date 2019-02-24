package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.Lead;

@Repository
public interface LeadRepo extends JpaRepository<Lead,Long>{

}
