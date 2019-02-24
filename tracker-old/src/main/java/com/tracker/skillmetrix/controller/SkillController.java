package com.tracker.skillmetrix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tracker.skillmetrix.exception.ResourceNotFoundException;
import com.tracker.skillmetrix.model.Skill;
import com.tracker.skillmetrix.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class SkillController {
	@Autowired
	SkillRepository skillRepository;
	@PostMapping("/skill")
	public Skill createSkill(@Valid @RequestBody Skill skill) {
		System.out.println("inside post method");
		
	    return skillRepository.save(skill);
	}
	
	@GetMapping("/skill")
	public List<Skill> getAllSkills() {
		System.out.println("inside Get method");
	    return skillRepository.findAll();
	}
	
	@GetMapping("/skill/{id}")
	public Skill getSkillById(@PathVariable(value = "id") String skillId) {
		System.out.println("inside Get method with specific id");
	    return skillRepository.findById(skillId)
	            .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
	}
	
	@PutMapping("/skill/{id}")
	public Skill updateSkill(@PathVariable(value = "id") String skillId,
	                                        @Valid @RequestBody Skill skillDetails) {
		System.out.println("inside put method");

	    Skill skill = skillRepository.findById(skillId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", skillId));

	  if(skillDetails.getPsno()!= null )
	    skill.setPsno(skillDetails.getPsno());
	  if(skillDetails.getBuname()!= null )
	    skill.setBuname(skillDetails.getBuname());
	  if(skillDetails.getName()!= null )
        skill.setName(skillDetails.getName());
      if(skillDetails.getGrade()!= null )
        skill.setGrade(skillDetails.getGrade());
      if(skillDetails.getLocation()!= null )
        skill.setLocation(skillDetails.getLocation());
      if(skillDetails.getProject_id()!= null )
        skill.setProject_id(skillDetails.getProject_id());
      if(skillDetails.getProject_name()!= null )
        skill.setProject_name(skillDetails.getProject_name());
      if(skillDetails.getProject_category()!= null )
        skill.setProject_category(skillDetails.getProject_category());
      if(skillDetails.getDelivery_manag()!= null )
        skill.setDelivery_manag(skillDetails.getDelivery_manag());
      if(skillDetails.getPrimary_skill()!= null )
        skill.setPrimary_skill(skillDetails.getPrimary_skill());
      if(skillDetails.getSecondary_skill()!= null )
        skill.setSecondary_skill(skillDetails.getSecondary_skill());
      if(skillDetails.getTraining_attended()!= null )
        skill.setTraining_attended(skillDetails.getTraining_attended());
        
	    Skill updatedSkill = skillRepository.save(skill);
	    return updatedSkill;
	}
	
	@DeleteMapping("/skill/{id}")
	public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") String skillId) {
		System.out.println("inside delete method");
	    Skill skill = skillRepository.findById(skillId)
	            .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));

	    skillRepository.delete(skill);

	   // return "Deleted Noteid :" +note.getId() +"Title :" +note.getTitle()+ "Content : " +note.getContent();
	//return ResponseEntity;
	   HttpHeaders responseHeaders = new HttpHeaders();
	return new ResponseEntity<>(skill,responseHeaders, HttpStatus.OK);
	   
     //return ResponseEntity.ok().build();
	}
}
