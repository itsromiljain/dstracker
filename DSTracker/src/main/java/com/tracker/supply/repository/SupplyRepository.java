package com.tracker.supply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.tracker.supply.model.SupplyDtls;
@Repository
public interface SupplyRepository extends JpaRepository<SupplyDtls,Long> {
	
	
	public static final String FIND_PROJECTS = "SELECT skill FROM Skill";
	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<String> findSkills();
	
	
}


