package com.tracker.controller.projectTracker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.DemandType;
import com.tracker.model.projectTracker.Location;
import com.tracker.service.projectTracker.DemandTypeService;

@RestController
public class DemandTypeController {
	
	@Autowired
	private DemandTypeService demandTypeService ;
	
@PostMapping("/addDemandType")
 public DemandType addDemandType(@RequestBody DemandType demandtype)
 {
	DemandType demand_Type = demandTypeService.addDemandType(demandtype);
	return demand_Type;
 }

@GetMapping("/getAllDemandType")
public ResponseEntity<List<DemandType>> getAllDemadType() {

	List<DemandType> demandType = new LinkedList<DemandType>();
	try {
		demandType = demandTypeService.getAllDemadType();
		return ResponseEntity.ok().body(demandType);
	} catch (ResourceNotFoundException e) {
		return ResponseEntity.notFound().build();
	}
}
}