package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.Skill;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Long>{

}
