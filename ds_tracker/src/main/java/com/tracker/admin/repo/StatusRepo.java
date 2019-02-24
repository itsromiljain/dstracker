package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.Status;


	@Repository
	public interface StatusRepo extends JpaRepository<Status, Long>{

}
