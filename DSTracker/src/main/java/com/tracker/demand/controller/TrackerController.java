package com.tracker.demand.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.demand.model.ProjTrakr;
import com.tracker.demand.service.TrackerService;

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

	// @GetMapping("/tracker/{id}")
	// public ResponseEntity<ProjTrakr> getaProject(@PathVariable("id") long id) {
	// ProjTrakr project;
	// try {
	// project = (ProjTrakr) trackerService.getAllProj(id).get(0);
	// return ResponseEntity.ok().body(project);
	// } catch (ResourceNotFoundException e) {
	// return ResponseEntity.notFound().build();
	// }
	// }

	@GetMapping("/tracker/{id}")
	public ResponseEntity<ProjTrakr> getaProject(@PathVariable("id") long id) {
		ProjTrakr project;
		List<BigInteger> suggestedSupplyList = new ArrayList<BigInteger>();
		try {
			List<BigInteger> suggestedSupply = new ArrayList<BigInteger>();
			project = (ProjTrakr) trackerService.getAllProj(id).get(0);
			String skill = project.getSkill();

			List<String> elephantList = Arrays.asList(skill.split(","));
			   System.out.println(elephantList);

			
			
			StringBuilder sb3 = new StringBuilder();
			sb3.append("Select supplyid,skill,supplyname from supplydtls");
			List<Object[]> results = entityManager.createNativeQuery(sb3.toString()).getResultList();

			results.stream().forEach((record) -> {
				BigInteger sid = (BigInteger) record[0];
			      //  System.out.println(sid);
			        String skilltest = (String) record[1];
			     //   System.out.println(skilltest);
			        List<String> supplyList = Arrays.asList(skilltest.split(","));
			        System.out.println(supplyList);
			        String supplyname = (String) record[2];
			      //  System.out.println(supplyname);
			        
			        String pattern = elephantList.stream()
					          .map(Pattern::quote)
					          .collect(Collectors.joining("|", ".*(", ").*"));

					    Pattern re = Pattern.compile(pattern);
					  
					    
					    boolean x = supplyList.stream()
						        .anyMatch(t -> re.matcher(t).matches());
					 
					    if(x == true) {
					    	System.out.println("match list:   " + sid);
					    	 suggestedSupply.add(sid);
					    }else {
					    	System.out.println("nonmatch list:   " + sid);
					    }
			        
			});
			
			
		
			 System.out.println("match list:   " + suggestedSupply);
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
