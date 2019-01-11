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
import com.tracker.model.projectTracker.Skill;
import com.tracker.service.projectTracker.SkillService;

@RestController
public class SkillController {
	@Autowired
	SkillService skillService;
	
	@PostMapping("/addSkill")
	 public Skill addSkill(@RequestBody Skill skill)
	 {
		Skill skill_Type = skillService.addSkill(skill);
		return skill_Type;
	 }
	
	@GetMapping("/getAllSkill")
	public ResponseEntity<List<Skill>> getAllSkill() {

		List<Skill> Skill = new LinkedList<Skill>();
		try {
			Skill = skillService.getAllSkill();
			return ResponseEntity.ok().body(Skill);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
