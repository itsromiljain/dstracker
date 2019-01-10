package com.tracker.controller.projectTracker;


import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.ProjTrakr;
import com.tracker.service.projectTracker.TrackerService;


@RestController
@CrossOrigin
public class TrackerController {
	@Autowired
	private TrackerService trackerService;

	@GetMapping("/tracker/")
	public ResponseEntity<List<ProjTrakr>> getAllProjects() {
		System.out.println("inside");
		List<ProjTrakr> projects = new LinkedList<ProjTrakr>();
		try {
			projects = trackerService.getAllProj(0l);
			return ResponseEntity.ok().body(projects);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/tracker/{id}")
	public ResponseEntity<ProjTrakr> getaProject(@PathVariable("id") long id) {
		ProjTrakr project;
		try {
			project = (ProjTrakr) trackerService.getAllProj(id).get(0);
			return ResponseEntity.ok().body(project);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/tracker")
	public  ResponseEntity<ProjTrakr> registerProject(@RequestBody ProjTrakr nwproject) {
		ProjTrakr projTrakr = trackerService.addProj(nwproject);
		try {
			return ResponseEntity.status(201).body(projTrakr);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/tracker/{id}")
	public ResponseEntity<Void> updateProject(@PathVariable int id, @RequestBody ProjTrakr exstProject) {
		try {
			trackerService.UpdateProj(exstProject);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/tracker/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable long id) {
		try {
			trackerService.deleteProj(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
