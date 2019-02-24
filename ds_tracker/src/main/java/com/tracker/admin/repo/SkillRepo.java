package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.Skill;

import java.util.List;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Long>{

    @Query("SELECT skill from Skill")
    public List<String> getAllSkillNames();

}
