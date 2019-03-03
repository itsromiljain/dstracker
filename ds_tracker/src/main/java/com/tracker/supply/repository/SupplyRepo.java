package com.tracker.supply.repository;


import com.tracker.supply.model.SupplyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplyRepo extends JpaRepository<SupplyDetail, Long> {

    @Query("SELECT sd FROM SupplyDetail sd WHERE sd.submittedBy.emailId=:emailId AND sd.supplyId=:supplyId AND sd.isArchived=0")
    public Optional<SupplyDetail> findById(String emailId, long supplyId);

    @Query("SELECT sd FROM SupplyDetail sd WHERE sd.submittedBy.emailId=:emailId AND sd.isArchived=0" )
    public List<SupplyDetail> findAllSupplyByUser(String emailId);

    @Query("SELECT supplyId, skill, supplyName FROM SupplyDetail sd WHERE sd.isArchived=0")
    public List<Object[]> getSupplyDetails();

    // Fetch only non archived/active demands
    @Query("SELECT sd FROM SupplyDetail sd WHERE sd.isArchived=1")
    public List<SupplyDetail> findAllArchivedSupply();

    // Update the supply as archived set isArchived=1
    @Query("UPDATE SupplyDetail sd SET sd.isArchived=1 where sd.supplyId =:supplyId")
    public void archiveSupplyById(@Param("supplyId") long supplyId);

    // Update all the supply as archived set isArchived=1
    @Query("UPDATE SupplyDetail sd SET sd.isArchived=1 where sd.supplyId IN (:supplyIds)")
    public void archiveSupply(@Param("supplyIds") List<Long> supplyIds);
		
}


