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
import com.tracker.model.projectTracker.Status;
import com.tracker.service.projectTracker.StatusService;




@RestController
public class StatusController {
	
	@Autowired
	 StatusService statusService;
	
	@PostMapping("/addDemandStatus")
	public Status addStatus(@RequestBody Status status)
	{
		Status sta = statusService.addStatus(status);
		return sta;
	}

	@GetMapping("/getAllDemandStatus")
	public ResponseEntity<List<Status>> getAllLocation() {

		List<Status> Status = new LinkedList<Status>();
		try {
			Status = statusService.getAllDemandStatus();
			return ResponseEntity.ok().body(Status);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
	

}
