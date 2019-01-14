package com.tracker.demand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.demand.model.ProjTrakr;



@Repository
public interface TrackerRepository extends JpaRepository<ProjTrakr, Long> {

}

