package com.tracker.demand.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.pojo.DemandTO;
import com.tracker.demand.service.DemandService;
import com.tracker.supply.pojo.SupplyTO;
import com.tracker.supply.service.SupplyService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class DemandTrackerController {
    @Autowired
    private DemandService demandService;

    @Autowired
    private SupplyService supplyService;


    @GetMapping("/user/{emailId}/demand")
    public ResponseEntity<List<DemandTO>> getDemands(@PathVariable(name = "emailId", required = true) String emailId,
                                                         @RequestParam(name = "role") String role) {
        try {
            if (StringUtils.isEmpty(role) || role.equalsIgnoreCase("TA")) {
                return ResponseEntity.ok().body(demandService.getAllDemands());
            } else {
                return ResponseEntity.ok().body(demandService.getDemandsByUser(emailId));
            }

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{emailId}/demand/{id}")
    public ResponseEntity<DemandTO> getDemandById(@PathVariable(name="emailId", required = true) String emailId,
                                                  @PathVariable("id") String demandId) {
        try {
            DemandTO demandTO = demandService.getDemandById(emailId, demandId);
            return ResponseEntity.ok().body(demandTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{emailId}/demand/{id}/suggestedSupply")
    public ResponseEntity<DemandTO> getSuggestedSupplyForDemand(@PathVariable(name="emailId", required = true) String emailId, @PathVariable("id") String demandId) {
        try {
            Set<SupplyTO> suggestedSupply = new HashSet<>();
            DemandTO demandTO = demandService.getDemandById(emailId, demandId);
            String skill = demandTO.getSkills();
            List<String> elephantList = Arrays.asList(skill.split(","));
            List<SupplyTO> supplyTOs = supplyService.getAllSupply();
            supplyTOs.stream().forEach((supplyTO) -> {
                String skillTest = supplyTO.getSkillSummary();
                List<String> skillList = Arrays.asList(skillTest.split(","));
                String pattern = elephantList.stream().map(Pattern::quote)
                        .collect(Collectors.joining("|", ".*(", ").*"));
                Pattern re = Pattern.compile(pattern);
                if (skillList.stream().anyMatch(t -> re.matcher(t).matches())) {
                    suggestedSupply.add(supplyTO);
                }
            });

            if(CollectionUtils.isEmpty(demandTO.getSupply())){
                demandTO.setSupply(suggestedSupply);
            }else {
                Set<SupplyTO> selectedSupplies = demandTO.getSupply();
                selectedSupplies.addAll(suggestedSupply);
                demandTO.setSupply(selectedSupplies);
            }

            return ResponseEntity.ok().body(demandTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/{emailId}/demand")
    public ResponseEntity<DemandTO> createDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody DemandTO newDemand) {
        try {
            demandService.createDemand(emailId, newDemand);
            return ResponseEntity.status(201).body(newDemand);
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/user/{emailId}/demand")
    public ResponseEntity<Void> updateDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody DemandTO existingDemand) {
        try {
            demandService.updateDemand(emailId, existingDemand);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{emailId}/archive")
    public ResponseEntity<Void> archiveDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody List<String> demandIds) {
        try {
            demandService.archiveDemand(demandIds);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
