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

import com.tracker.model.projectTracker.Status;
import com.tracker.model.projectTracker.YrOfExp;
import com.tracker.service.projectTracker.YrOfExpService;

@RestController
public class YrOfExpController {
@Autowired
YrOfExpService yrOfExpService;


@PostMapping("/addYrOfExp")
	public YrOfExp addYrOfExp(@RequestBody YrOfExp yrOfExp) {
		return yrOfExpService.addYrOfExp(yrOfExp);
	}


@GetMapping("/getAllyrOfExp")
public ResponseEntity<List<YrOfExp>> getAllyrOfExp() {

	List<YrOfExp> YrOfExp = new LinkedList<YrOfExp>();
	try {
		YrOfExp = yrOfExpService.getAllyrOfExp();
		return ResponseEntity.ok().body(YrOfExp);
	} catch (ResourceNotFoundException e) {
		return ResponseEntity.notFound().build();
	}

}


}
