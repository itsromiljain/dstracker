package com.tracker.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.admin.model.AppleManager;

@Repository
public interface AppleManagerRepo extends JpaRepository<AppleManager, Long>{

}
