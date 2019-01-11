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

import com.tracker.model.projectTracker.Location;
import com.tracker.model.supply.PremiumRate;
import com.tracker.service.supply.PremiumRateService;

@RestController
public class PremiumRateController {
	@Autowired
	PremiumRateService premiumRateService;

	@PostMapping("/addPremiumRate")
	public PremiumRate addPremiumRate(@RequestBody PremiumRate premiumRate) {
		PremiumRate PR = premiumRateService.addPremiumRate(premiumRate);
		return PR;

	}

	@GetMapping("/getAllPremiumRate")
	public ResponseEntity<List<PremiumRate>> getAllPremiumRate() {

		List<PremiumRate> PremiumRate = new LinkedList<PremiumRate>();
		try {
			PremiumRate = premiumRateService.getAllPremiumRate();
			return ResponseEntity.ok().body(PremiumRate);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
}
