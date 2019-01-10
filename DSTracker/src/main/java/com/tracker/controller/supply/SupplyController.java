package com.tracker.controller.supply;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.model.supply.SupplyDtls;
import com.tracker.service.supply.SupplyService;

@RestController
@CrossOrigin
public class SupplyController {
	@Autowired
	private SupplyService supplyService;

	@GetMapping("/getAllsupply/")
	public ResponseEntity<List<SupplyDtls>> getAllProjects() {
		List<SupplyDtls> projects = new LinkedList<SupplyDtls>();
		try {
			projects = supplyService.getAllSupply();
			return ResponseEntity.ok().body(projects);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	/*@GetMapping("/supply/{id}")
	public ResponseEntity<Optional<supplyDtls>> getaProject(@PathVariable("id") long id) {
		SupplyDtls supplyDtls;
		try {
			Optional<supplyDtls> = (SupplyDtls) supplyService.getSupply(id);
			return ResponseEntity.ok().body(supplyDtls);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
@PostMapping("/supply")
	public  ResponseEntity<SupplyDtls> registerProject(@RequestPart("json") SupplyDtls nwsupplyDtls, @RequestPart("file")MultipartFile[] file) {
		
		
		SupplyDtls supplyDtls = supplyService.addSupply(nwsupplyDtls,file);
		try {
			return ResponseEntity.status(201).body(supplyDtls);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}
	*/

	@PostMapping("/supply")
	public  ResponseEntity<SupplyDtls> registerProject(@RequestBody SupplyDtls nwsupplyDtls) {
		
		
		SupplyDtls supplyDtls = supplyService.addSupply(nwsupplyDtls);
		try {
			return ResponseEntity.status(201).body(supplyDtls);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/supply/{id}")
	public ResponseEntity<Void> updateProject(@PathVariable int id, @RequestBody SupplyDtls exstsupplyDtls) {
		try {
			supplyService.UpdateSupply(exstsupplyDtls);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/supply/{id}")
	public ResponseEntity<Void> deleteSupply(@PathVariable long id) {
		try {
			supplyService.deleteSupply(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
