package com.tracker.demand.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.model.DemandDetail;
import com.tracker.demand.service.DemandService;
import com.tracker.supply.service.SupplyService;
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
public class DemandTrackerController {
	@Autowired
	private DemandService trackerService;

	@Autowired
	private SupplyService supplyService;

	//@PersistenceContext
	//private EntityManager entityManager;

	@GetMapping("/tracker")
	public ResponseEntity<List<DemandDetail>> getAllProjects() {
		try {
			List<DemandDetail> projects = trackerService.getAllProjects();
			return ResponseEntity.ok().body(projects);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/tracker/{id}")
	public ResponseEntity<DemandDetail> getProject(@PathVariable("id") long id) {
		try {
			List<Object> suggestedSupply = new ArrayList<Object>();

			DemandDetail project = (DemandDetail) trackerService.getProjectById(id);
			String skill = project.getSkill();

			List<String> elephantList = Arrays.asList(skill.split(","));			

			//StringBuilder sb3 = new StringBuilder();
			//sb3.append("Select supply_id,skill,supply_name from supply_detail");
			//List<Object[]> results = entityManager.createNativeQuery(sb3.toString()).getResultList();
			List<Object[]> results = supplyService.getSupplyDetails();

			results.stream().forEach((record) -> {
				Map<Object, Object> ocurenceMap = new HashMap<Object, Object>();
				BigInteger sid = (BigInteger) record[0];
				String skillTest = (String) record[1];
				List<String> skillList = Arrays.asList(skillTest.split(","));
				String supplyName = (String) record[2];
				String pattern = elephantList.stream().map(Pattern::quote)
						.collect(Collectors.joining("|", ".*(", ").*"));
				Pattern re = Pattern.compile(pattern);
				if (skillList.stream().anyMatch(t -> re.matcher(t).matches())) {
					ocurenceMap.put("supplyId", sid);
					ocurenceMap.put("skillTest", skillTest);

					ocurenceMap.put("supplyName", supplyName);
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
	public ResponseEntity<DemandDetail> addProject(@RequestBody DemandDetail newproject) {
		DemandDetail projTrakr = trackerService.addProject(newproject);
		try {
			return ResponseEntity.status(201).body(projTrakr);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/tracker/{id}")
	public ResponseEntity<Void> updateProject(@PathVariable int id, @RequestBody DemandDetail existingProject) {
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
