package com.tracker.demand.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.model.ProjectTracker;
import com.tracker.demand.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TrackerController {
	@Autowired
	private TrackerService trackerService;

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/tracker")
	public ResponseEntity<List<ProjectTracker>> getAllProjects() {
		try {
			List<ProjectTracker> projects = trackerService.getAllProjects();
			return ResponseEntity.ok().body(projects);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/tracker/{id}")
	public ResponseEntity<ProjectTracker> getProject(@PathVariable("id") long id) {
		try {
			List<Object> suggestedSupply = new ArrayList<Object>();

			ProjectTracker project = (ProjectTracker) trackerService.getProjectById(id);
			String skill = project.getSkill();

			List<String> elephantList = Arrays.asList(skill.split(","));			

			StringBuilder sb3 = new StringBuilder();
			sb3.append("Select supplyid,skill,supplyname from supplydtls");
			List<Object[]> results = entityManager.createNativeQuery(sb3.toString()).getResultList();

			results.stream().forEach((record) -> {
				Map<Object, Object> ocurenceMap = new HashMap<Object, Object>();
				BigInteger sid = (BigInteger) record[0];

				String skilltest = (String) record[1];

				List<String> supplyList = Arrays.asList(skilltest.split(","));
				
				String supplyname = (String) record[2];

				String pattern = elephantList.stream().map(Pattern::quote)
						.collect(Collectors.joining("|", ".*(", ").*"));

				Pattern re = Pattern.compile(pattern);

				boolean x = supplyList.stream().anyMatch(t -> re.matcher(t).matches());

				if (x == true) {

					ocurenceMap.put("supplyId", sid);
					ocurenceMap.put("skilltest", skilltest);

					ocurenceMap.put("supplyname", supplyname);
					suggestedSupply.add(ocurenceMap);
				}
			});

			project.setSuggestedSupply(suggestedSupply);

			return ResponseEntity.ok().body(project);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/tracker")
	public ResponseEntity<ProjectTracker> addProject(@RequestBody ProjectTracker newproject) {
		ProjectTracker projTrakr = trackerService.addProject(newproject);
		try {
			return ResponseEntity.status(201).body(projTrakr);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/tracker/{id}")
	public ResponseEntity<Void> updateProject(@PathVariable int id, @RequestBody ProjectTracker existingProject) {
		try {
			trackerService.updateProject(existingProject);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/tracker/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable long id) {
		try {
			trackerService.deleteProject(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
