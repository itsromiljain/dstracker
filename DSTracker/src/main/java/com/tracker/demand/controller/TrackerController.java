package com.tracker.demand.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
		List<BigInteger> suggestedSupply = new ArrayList<BigInteger>();
		try {
			project = (ProjTrakr) trackerService.getAllProj(id).get(0);
			String skill = project.getSkill();
		//	System.out.println("demand Skill: " + skill);
			List<String> elephantList = Arrays.asList(skill.split(","));

			StringBuilder sb = new StringBuilder();
			sb.append("Select supplyId from supplydtls");
			List<BigInteger> supplyid = entityManager.createNativeQuery(sb.toString()).getResultList();
			//System.out.println("skill list:   " + supplyid);

	
			for (BigInteger temp : supplyid) {
				//System.out.println(temp);
				
				StringBuilder sb1 = new StringBuilder();
				sb1.append("Select skill from supplydtls where supplyid="+temp);
				List<String> skill1 = entityManager.createNativeQuery(sb1.toString()).getResultList();
			//	System.out.println("skill list:   " + skill1);
				String pattern = elephantList.stream()
				          .map(Pattern::quote)
				          .collect(Collectors.joining("|", ".*(", ").*"));

				    Pattern re = Pattern.compile(pattern);

				    boolean x =  skill1.stream()
				        .allMatch(t -> re.matcher(t).matches());
				    
				   
				    if(x == true) {
				    	// System.out.println("match list:   " + temp);
				    	 suggestedSupply.add(temp);
				    }else {
				    	System.out.println("nonmatch list:   " + skill1);
				    }
			}
			
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
