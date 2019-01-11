package com.tracker.controller.supply;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.supply.PremiumRate;
import com.tracker.model.supply.SubmittedBy;
import com.tracker.service.supply.SubmittedByService;

@RestController
public class SubmittedByController {

	@Autowired
	SubmittedByService submittedByService;

	@PostMapping("/addSubmittedBy")
	public SubmittedBy addSubmittedBy(@RequestBody SubmittedBy submittedBy) {
		SubmittedBy SB = submittedByService.addSubmittedBy(submittedBy);
		return SB;
	}
	
	@GetMapping("/getAllSubmittedBy")
	public ResponseEntity<List<SubmittedBy>> getAllSubmittedBy() {

		List<SubmittedBy> SubmittedBy = new LinkedList<SubmittedBy>();
		try {
			SubmittedBy = submittedByService.getAllSubmittedBy();
			return ResponseEntity.ok().body(SubmittedBy);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
