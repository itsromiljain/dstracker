package com.tracker.assettracker.repository;

import org.springframework.stereotype.Repository;

import com.tracker.assettracker.model.Asset;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String>{
	
	

}
