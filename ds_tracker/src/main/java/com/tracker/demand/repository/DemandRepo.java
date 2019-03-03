package com.tracker.demand.repository;



import com.tracker.demand.model.DemandDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandRepo extends JpaRepository<DemandDetail, Long> {

    // Fetch only non archived/active demand
    @Query("SELECT dd FROM DemandDetail dd WHERE dd.demandId=:demandId AND dd.submittedBy.emailId=:emailId AND dd.isArchived=0")
    public Optional<DemandDetail> findById(@Param("emailId") String emailId, @Param("demandId") long demandId);

    @Query("SELECT dd FROM DemandDetail dd WHERE dd.submittedBy.emailId=:emailId AND dd.isArchived=0")
    public List<DemandDetail> findById(@Param("emailId") String emailId);

    // Fetch only non archived/active demands
    @Query("SELECT dd FROM DemandDetail dd WHERE dd.isArchived=0")
    public List<DemandDetail> findAll();


    // Fetch only non archived/active demands
    @Query("SELECT dd FROM DemandDetail dd WHERE dd.isArchived=1")
    public List<DemandDetail> findAllArchivedDemands();


    // Update the demands as archived set isArchived=1
    @Query("UPDATE DemandDetail dd SET dd.isArchived=1 where dd.demandId IN (:demandIds)")
    public void archiveDemand(@Param("demandIds") List<Long> demandIds);

}

