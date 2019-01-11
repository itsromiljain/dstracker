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

import com.tracker.model.projectTracker.PanelList;
import com.tracker.service.projectTracker.PanelListService;


@RestController 
public class PanelListController {
	
	@Autowired
	PanelListService panelListService;
	@PostMapping("/addPanelList")
	public PanelList panelList(@RequestBody PanelList panelList)
	{
		PanelList PL = panelListService.addPanelList(panelList);
		return PL;
	}
	

	@GetMapping("/getAllPanelList")
	public ResponseEntity<List<PanelList>>getAllPanelList(){
		List<PanelList> PanelList = new LinkedList<PanelList>();
		try {
			PanelList = panelListService.getAllPanelList();
			return ResponseEntity.ok().body(PanelList);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
