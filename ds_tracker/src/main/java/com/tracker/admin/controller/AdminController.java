package com.tracker.admin.controller;

import com.tracker.admin.model.*;
import com.tracker.admin.service.*;
import com.tracker.common.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class AdminController {

	@Autowired
	DemandTypeService demandTypeService;
	@Autowired
	AppleManagerService imtdmnameService;
	@Autowired
	LeadService leadService;
	@Autowired
	LocationService locationService;
	@Autowired
	PanelListService panelListService;
	@Autowired
	PriorityService priorityService;
	@Autowired
	SkillService skillService;
	@Autowired
	StatusService statusService;
	@Autowired
	YrOfExpService yrOfExpService;
	@Autowired
	SupplyStatusService supplyStatusService;
	@Autowired
	SubmittedByService submittedByService;
	@Autowired
	PremiumRateService premiumRateService;

	// add new DemandType
	@PostMapping("/addDemandType")
	public DemandType addDemandType(@RequestBody DemandType demandtype) {
		DemandType demand_Type = demandTypeService.addDemandType(demandtype);
		return demand_Type;
	}

	// get All DemandType
	@GetMapping("/getAllDemandType")
	public ResponseEntity<List<DemandType>> getAllDemadType() {

		List<DemandType> demandType = new LinkedList<DemandType>();
		try {
			demandType = demandTypeService.getAllDemadType();
			return ResponseEntity.ok().body(demandType);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// get All apple manager
	@GetMapping("/getAllapplel2mgr")
	public ResponseEntity<List<AppleManager>> getallAppleL2Manager() {

		List<AppleManager> AppleL2Manager = new LinkedList<AppleManager>();
		try {
			AppleL2Manager = imtdmnameService.getAllapplel2mgrName();
			return ResponseEntity.ok().body(AppleL2Manager);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// Add apple manager
	@PostMapping("/addAppleL2Manager")
	public ResponseEntity<AppleManager> addAppleL2Manager(@RequestBody AppleManager appleL2Manager) {
		System.out.println("appleL2Manager.getApplel2mngr_name()");
		System.out.println(appleL2Manager.getApplel2mngr_name());
		AppleManager al2Manager = imtdmnameService.addAppleL2Manager(appleL2Manager);
		try {
			return ResponseEntity.status(201).body(al2Manager);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// delete apple manager
	@PostMapping("/deleteAppleL2Manager/{id}")
	public ResponseEntity<String> deleteAppleL2Manager(@PathVariable(value = "id") long id) {
		imtdmnameService.deleteAppleL2Manager(id);
		try {
			return ResponseEntity.status(201).body("deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// Add new Lead
	@PostMapping("/addLead")
	public ResponseEntity<Lead> addLead(@RequestBody Lead lead) {
		Lead lead1 = leadService.addLead(lead);
		try {
			return ResponseEntity.status(201).body(lead1);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// Get All Lead
	@GetMapping("/getAllLead")
	public ResponseEntity<List<Lead>> getAllLead() {
		List<Lead> Lead = new LinkedList<Lead>();
		try {
			Lead = leadService.getAllLead();
			return ResponseEntity.ok().body(Lead);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new location
	@PostMapping("/addLocation")
	public Location location(@RequestBody Location location) {
		Location loc = locationService.addLocation(location);
		return loc;
	}

	// Get All Location
	@GetMapping("/getAllLocation")
	public ResponseEntity<List<Location>> getAllLocation() {

		List<Location> Location = new LinkedList<Location>();
		try {
			Location = locationService.getAllLocation();
			return ResponseEntity.ok().body(Location);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new Panel List
	@PostMapping("/addPanelList")
	public PanelList panelList(@RequestBody PanelList panelList) {
		PanelList PL = panelListService.addPanelList(panelList);
		return PL;
	}

	// get All Panel List
	@GetMapping("/getAllPanelList")
	public ResponseEntity<List<PanelList>> getAllPanelList() {
		List<PanelList> PanelList = new LinkedList<PanelList>();
		try {
			PanelList = panelListService.getAllPanelList();
			return ResponseEntity.ok().body(PanelList);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new Priority
	@PostMapping("/addPriority")
	public Priority addPriority(@RequestBody Priority priority) {
		Priority prio = priorityService.addPriority(priority);
		return prio;
	}

	// get All Priority
	@GetMapping("/getAllPriority")
	public ResponseEntity<List<Priority>> getAllPriority() {

		List<Priority> Priority = new LinkedList<Priority>();
		try {
			Priority = priorityService.getAllPriority();
			return ResponseEntity.ok().body(Priority);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new Skill
	@PostMapping("/addSkill")
	public Skill addSkill(@RequestBody Skill skill) {
		Skill skill_Type = skillService.addSkill(skill);
		return skill_Type;
	}

	// get All Skill
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

	// add new DemandStatus
	@PostMapping("/addDemandStatus")
	public Status addStatus(@RequestBody Status status) {
		Status sta = statusService.addStatus(status);
		return sta;
	}

	// get All DemandStatus
	@GetMapping("/getAllDemandStatus")
	public ResponseEntity<List<Status>> getAllDemandStatus() {

		List<Status> Status = new LinkedList<Status>();
		try {
			Status = statusService.getAllDemandStatus();
			return ResponseEntity.ok().body(Status);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new YrOfExp
	@PostMapping("/addYrOfExp")
	public YrOfExp addYrOfExp(@RequestBody YrOfExp yrOfExp) {
		return yrOfExpService.addYrOfExp(yrOfExp);
	}

	// get All YrOfExp
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

	// add new SupplyStatus
	@PostMapping("/addSupplyStatus")
	public SupplyStatus status(@RequestBody SupplyStatus supplyStatus) {
		return supplyStatusService.addStatus(supplyStatus);
	}

	// get All SupplyStatus
	@GetMapping("/getAllSupplyStatus")
	public ResponseEntity<List<SupplyStatus>> getAllSupplyStatus() {

		List<SupplyStatus> SupplyStatus = new LinkedList<SupplyStatus>();
		try {
			SupplyStatus = supplyStatusService.getAllSupplyStatus();
			return ResponseEntity.ok().body(SupplyStatus);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// add new SubmittedBy
	@PostMapping("/addSubmittedBy")
	public SubmittedBy addSubmittedBy(@RequestBody SubmittedBy submittedBy) {
		SubmittedBy SB = submittedByService.addSubmittedBy(submittedBy);
		return SB;
	}

	// get All SubmittedBy
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

	// add new PremiumRate
	@PostMapping("/addPremiumRate")
	public PremiumRate addPremiumRate(@RequestBody PremiumRate premiumRate) {
		PremiumRate PR = premiumRateService.addPremiumRate(premiumRate);
		return PR;

	}

	// get All PremiumRate
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
