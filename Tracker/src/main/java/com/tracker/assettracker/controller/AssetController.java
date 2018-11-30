package com.tracker.assettracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.assettracker.exception.ResourceNotFoundException;
import com.tracker.assettracker.model.Asset;
import com.tracker.assettracker.repository.AssetRepository;


@RestController
@RequestMapping("/api")
public class AssetController {
	
	
	@Autowired
	AssetRepository assetRepository;
	
	
	@PostMapping("/asset")
	public Asset createAsset(@Valid @RequestBody Asset asset) {
		System.out.println("inside post method");
	    return assetRepository.save(asset);
	}
	@GetMapping("/asset")
	public List<Asset> getAllAssets() {
	    return assetRepository.findAll();
	}
	@GetMapping("/asset/{id}")
	public Asset getAssetById(@PathVariable(value = "id") String assetid) {
	    return assetRepository.findById(assetid)
	            .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetid));
	}
	@PutMapping("/asset/{id}")
	public Asset updateAsset(@PathVariable(value = "id") String assetid,
	                                        @Valid @RequestBody Asset assetDetails) {

	    Asset asset = assetRepository.findById(assetid)
	            .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetid));

	    if(assetDetails.getPsNumber()!= null )
		    asset.setPsNumber(assetDetails.getPsNumber());
	    if(assetDetails.getUserName()!= null )
	    asset.setUserName(assetDetails.getUserName());
	    if(assetDetails.getComputerName()!= null )
		    asset.setComputerName(assetDetails.getComputerName());
	    if(assetDetails.getSerialNumber()!= null )
		    asset.setSerialNumber(assetDetails.getSerialNumber()); 
	    if(assetDetails.getInventoryNumber()!= null )
		    asset.setInventoryNumber(assetDetails.getInventoryNumber());
	    if(assetDetails.getPoNumber()!= null )
		    asset.setPoNumber(assetDetails.getPoNumber());
	    if(assetDetails.getAssetNumber()!= null )
		    asset.setAssetNumber(assetDetails.getAssetNumber());
	    if(assetDetails.getRamSize()!= null )
		    asset.setRamSize(assetDetails.getRamSize());
	        
		    Asset updatedAsset = assetRepository.save(asset);
		    return updatedAsset;
	}
	
	@DeleteMapping("/asset/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") String assetid) {
	    Asset asset = assetRepository.findById(assetid)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", assetid));

	    assetRepository.delete(asset);

	   // return "Deleted Noteid :" +note.getId() +"Title :" +note.getTitle()+ "Content : " +note.getContent();
	//return ResponseEntity;
	    HttpHeaders responseHeaders = new HttpHeaders();
	return new ResponseEntity<>(asset,responseHeaders, HttpStatus.OK);
	}

}
