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

import com.tracker.model.projectTracker.Priority;
import com.tracker.model.projectTracker.Status;
import com.tracker.service.projectTracker.PriorityService;

@RestController
public class PriorityController {
	
	@Autowired
PriorityService priorityService;
	
	@PostMapping("/addPriority")
	public Priority addPriority(@RequestBody Priority priority)
	 {
		Priority prio = priorityService.addPriority(priority);
		return prio;
	 }
	
	
	@GetMapping("/getAllPriority")
	public ResponseEntity<List<Priority>> getAllLocation() {

		List<Priority> Priority = new LinkedList<Priority>();
		try {
			Priority = priorityService.getAllPriority();
			return ResponseEntity.ok().body(Priority);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
