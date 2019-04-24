package com.tracker.admin.controller;

import com.tracker.admin.model.*;
import com.tracker.admin.service.*;
import com.tracker.common.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/admin")
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
    ExperienceService yrOfExpService;
	@Autowired
	SupplyStatusService supplyStatusService;
	@Autowired
	SubmittedByService submittedByService;
	@Autowired
	PremiumRateService premiumRateService;

	//Import Service
	@Autowired
	ImportService importService;

	// add new DemandType
	@PostMapping("/demandType")
	public DemandType addDemandType(@RequestBody DemandType demandtype) {
		return demandTypeService.addDemandType(demandtype);
	}

	// get All DemandType
	@GetMapping("/demandType")
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
	@GetMapping("/appleManager")
	public ResponseEntity<List<AppleManager>> getallAppleL2Manager() {
		List<AppleManager> appleManagers = new LinkedList<AppleManager>();
		try {
            appleManagers = imtdmnameService.getAppleManagers();
			return ResponseEntity.ok().body(appleManagers);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// Add apple manager
	@PostMapping("/appleManager")
	public ResponseEntity<AppleManager> addAppleL2Manager(@RequestBody AppleManager appleL2Manager) {
		AppleManager appleManager = imtdmnameService.addAppleManager(appleL2Manager);
		try {
			return ResponseEntity.status(201).body(appleManager);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// delete apple manager
	@DeleteMapping("/appleManager/{id}")
	public ResponseEntity<String> deleteAppleL2Manager(@PathVariable(value = "id") long id) {
		imtdmnameService.deleteAppleManager(id);
		try {
			return ResponseEntity.status(201).body("deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// Add new Lead
	@PostMapping("/lead")
	public ResponseEntity<Lead> addLead(@RequestBody Lead lead) {
		Lead lead1 = leadService.addLead(lead);
		try {
			return ResponseEntity.status(201).body(lead1);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	// Get All Lead
	@GetMapping("/lead")
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
	@PostMapping("/location")
	public Location location(@RequestBody Location location) {
		return locationService.addLocation(location);
	}

	// Get All Location
	@GetMapping("/location")
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
	@PostMapping("/panelList")
	public PanelList panelList(@RequestBody PanelList panelList) {
		return panelListService.addPanelList(panelList);
	}

	// get All Panel List
	@GetMapping("/panelList")
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
	@PostMapping("/priority")
	public Priority addPriority(@RequestBody Priority priority) {
		return priorityService.addPriority(priority);
	}

	// get All Priority
	@GetMapping("/priority")
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
	@PostMapping("/skill")
	public Skill addSkill(@RequestBody Skill skill) {
		return skillService.addSkill(skill);
	}

	// get All Skill
	@GetMapping("/skill")
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
	@PostMapping("/demandStatus")
	public DemandStatus addStatus(@RequestBody DemandStatus status) {
		return statusService.addStatus(status);
	}

	// get All DemandStatus
	@GetMapping("/demandStatus")
	public ResponseEntity<List<DemandStatus>> getAllDemandStatus() {

		List<DemandStatus> Status = new LinkedList<DemandStatus>();
		try {
			Status = statusService.getAllDemandStatus();
			return ResponseEntity.ok().body(Status);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new Experience
	@PostMapping("/experience")
	public Experience addYrOfExp(@RequestBody Experience experience) {
		return yrOfExpService.addYrOfExp(experience);
	}

	// get All Experience
	@GetMapping("/experience")
	public ResponseEntity<List<Experience>> getAllyrOfExp() {
		List<Experience> Experience = new LinkedList<Experience>();
		try {
			Experience = yrOfExpService.getAllyrOfExp();
			return ResponseEntity.ok().body(Experience);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// add new SupplyStatus
	@PostMapping("/supplyStatus")
	public SupplyStatus status(@RequestBody SupplyStatus supplyStatus) {
		return supplyStatusService.addStatus(supplyStatus);
	}

	// get All SupplyStatus
	@GetMapping("/supplyStatus")
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
	@PostMapping("/submittedBy")
	public SubmittedBy addSubmittedBy(@RequestBody SubmittedBy submittedBy) {
		SubmittedBy SB = submittedByService.addSubmittedBy(submittedBy);
		return SB;
	}

	// get All SubmittedBy
	@GetMapping("/submittedBy")
	public ResponseEntity<List<SubmittedBy>> getAllSubmittedBy() {
		List<SubmittedBy> submittedBy = new LinkedList<SubmittedBy>();
		try {
			submittedBy = submittedByService.getAllSubmittedBy();
			return ResponseEntity.ok().body(submittedBy);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// add new PremiumRate
	@PostMapping("/premiumRate")
	public PremiumRate addPremiumRate(@RequestBody PremiumRate premiumRate) {
		return premiumRateService.addPremiumRate(premiumRate);

	}

	// get All PremiumRate
	@GetMapping("/premiumRate")
	public ResponseEntity<List<PremiumRate>> getAllPremiumRate() {
		List<PremiumRate> premiumRate = new LinkedList<PremiumRate>();
		try {
			premiumRate = premiumRateService.getAllPremiumRate();
			return ResponseEntity.ok().body(premiumRate);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// Import Demands from Excel
	@PostMapping("/import/demand")
	public ResponseEntity<Object> importDemand(@RequestParam("file") MultipartFile file) {
		try {
			importService.importDemandFile(file);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	// Import Supply from Excel
	@PostMapping("/import/supply")
	public ResponseEntity<Object> importSupply(@RequestParam("file") MultipartFile file) {
		try {
			importService.importSupplyFile(file);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

	private void validateFile(MultipartFile file) {
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			if(!fileName.endsWith(".xlsx")){
				// file is not xlsx type
			}
		}else {
			// Empty file
		}
	}
}
