package com.tracker.demand.repository;



import com.tracker.demand.model.DemandDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepo extends JpaRepository<DemandDetail, Long> {

}

