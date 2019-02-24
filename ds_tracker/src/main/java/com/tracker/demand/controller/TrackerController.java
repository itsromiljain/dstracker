package com.tracker.demand.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.model.ProjTrakr;
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

	@GetMapping("/tracker/")
	public ResponseEntity<List<ProjTrakr>> getAllProjects() {

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
			List<Object> suggestedSupply = new ArrayList<Object>();

			project = (ProjTrakr) trackerService.getAllProj(id).get(0);
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
	public ResponseEntity<ProjTrakr> registerProject(@RequestBody ProjTrakr nwproject) {
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
