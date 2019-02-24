package com.tracker.controller.projectTracker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.Imt;
import com.tracker.service.projectTracker.ImtdmnameService;

@RestController
@CrossOrigin
public class ImtController {

	@Autowired
	private ImtdmnameService imtdmnameService;

	@GetMapping("/imts/")
	public ResponseEntity<List<Imt>> getAllProjects() {
		List<Imt> imt = new LinkedList<Imt>();
		try {
			imt = imtdmnameService.getAllImtNm();
			return ResponseEntity.ok().body(imt);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
