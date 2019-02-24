package com.tracker.skillmetrix.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tracker.skillmetrix.model.Skill;

@Repository
public interface SkillRepository  extends JpaRepository<Skill, String>{
	 //String fetchByPSNumber(@Param("psno") String psno);
	

}
