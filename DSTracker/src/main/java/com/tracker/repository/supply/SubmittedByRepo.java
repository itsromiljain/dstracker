package com.tracker.repository.supply;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.model.supply.SubmittedBy;

public interface SubmittedByRepo extends JpaRepository<SubmittedBy, Long>{

}
