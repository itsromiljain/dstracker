package com.tracker.controller.projectTracker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.projectTracker.AppleManager;
import com.tracker.service.projectTracker.ImtdmnameService;
@RestController
public class AppleManagerController {
	@Autowired
	private ImtdmnameService imtdmnameService;

	@GetMapping("/getAllapplel2mgr")
	public ResponseEntity<List<AppleManager>> getallAppleL2Manager() {

		List<AppleManager> AppleL2Manager = new LinkedList<AppleManager>();
		try {
			AppleL2Manager = imtdmnameService.getAllapplel2mgrName();
			System.out.println(AppleL2Manager);
			return ResponseEntity.ok().body(AppleL2Manager);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping("/addAppleL2Manager")
	public ResponseEntity<AppleManager> addAppleL2Manager(@RequestBody AppleManager appleL2Manager){
		System.out.println("appleL2Manager.getApplel2mngr_name()");
		System.out.println(appleL2Manager.getApplel2mngr_name());
		AppleManager al2Manager = imtdmnameService.addAppleL2Manager(appleL2Manager);
		try {
			return ResponseEntity.status(201).body(al2Manager);
		}catch (Exception e){
			return ResponseEntity.status(404).build();
		}
	}
	
	
	@PostMapping("/deleteAppleL2Manager/{id}")
	public ResponseEntity<String> deleteAppleL2Manager(@PathVariable(value="id")long id){
		imtdmnameService.deleteAppleL2Manager(id);
		try {
			return ResponseEntity.status(201).body("deleted successfully");
		}catch (Exception e){
			return ResponseEntity.status(404).build();
		}
	}
}
