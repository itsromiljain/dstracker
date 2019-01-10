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

import com.tracker.model.projectTracker.AppleManager;
import com.tracker.model.projectTracker.Lead;
import com.tracker.service.projectTracker.LeadService;

@RestController
public class LeadController {
	@Autowired
	LeadService leadService;

	@PostMapping("/addLead")
	public ResponseEntity<Lead> addLead(@RequestBody Lead lead) {
		Lead lead1 = leadService.addLead(lead);
		try {
			return ResponseEntity.status(201).body(lead1);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@GetMapping("/getAllLead")
	public ResponseEntity<List<Lead>> getAllLead() {
		List<Lead> Lead = new LinkedList<Lead>();
		try {
			Lead = leadService.getAllLead();
			return ResponseEntity.ok().body(Lead);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
