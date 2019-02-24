package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.admin.model.Experience;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Long>{

}
