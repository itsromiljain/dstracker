package com.tracker.controller.projectTracker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.DelvryMgr;
import com.tracker.service.projectTracker.ImtdmnameService;

@RestController
@CrossOrigin
public class DvrymanagerController {
	
	@Autowired
	private ImtdmnameService imtdmnameService;

	@GetMapping("/deliverymgr/")
	public ResponseEntity<List<DelvryMgr>> getAllProjects() {
		List<DelvryMgr> dmanager = new LinkedList<DelvryMgr>();
		try {
			dmanager = imtdmnameService.getAllDmNam();
			return ResponseEntity.ok().body(dmanager);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
