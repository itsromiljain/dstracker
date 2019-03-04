package com.tracker.demand.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.demand.model.DemandDetail;
import com.tracker.demand.service.DemandService;
import com.tracker.supply.model.SupplyDetail;
import com.tracker.supply.service.SupplyService;
import com.tracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class DemandTrackerController {
    @Autowired
    private DemandService trackerService;

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{emailId}/demand")
    public ResponseEntity<List<DemandDetail>> getDemands(@PathVariable(name = "emailId", required = true) String emailId,
                                                         @RequestParam(name = "role") String role) {
        try {
            if (StringUtils.isEmpty(role) || role.equalsIgnoreCase("TA")) {
                return ResponseEntity.ok().body(trackerService.getAllDemands());
            } else {
                return ResponseEntity.ok().body(trackerService.getDemandsByUser(emailId));
            }

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{emailId}/demand/{id}")
    public ResponseEntity<DemandDetail> getDemandById(@PathVariable(name="emailId", required = true) String emailId,
                                                  @PathVariable("id") long demandId) {
        try {
            DemandDetail demandDetail = trackerService.getDemandById(emailId, demandId);
            return ResponseEntity.ok().body(demandDetail);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{emailId}/demand/{id}/supply")
    public ResponseEntity<DemandDetail> getSupplyForDemand(@PathVariable(name="emailId", required = true) String emailId, @PathVariable("id") long demandId) {
        try {
            List<Object> suggestedSupply = new ArrayList<Object>();
            DemandDetail demandDetail = trackerService.getDemandById(emailId, demandId);
            String skill = demandDetail.getSkill();
            List<String> elephantList = Arrays.asList(skill.split(","));
            List<SupplyDetail> supplyDetails = supplyService.getAllSupply();
            supplyDetails.stream().forEach((supplyDetail) -> {
                String skillTest = supplyDetail.getSkill();
                List<String> skillList = Arrays.asList(skillTest.split(","));
                String pattern = elephantList.stream().map(Pattern::quote)
                        .collect(Collectors.joining("|", ".*(", ").*"));
                Pattern re = Pattern.compile(pattern);
                if (skillList.stream().anyMatch(t -> re.matcher(t).matches())) {
                    suggestedSupply.add(supplyDetail);
                }
            });
            demandDetail.setSuggestedSupply(suggestedSupply);
            return ResponseEntity.ok().body(demandDetail);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/{emailId}/demand")
    public ResponseEntity<DemandDetail> createDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody DemandDetail newDemand) {
        try {
            DemandDetail demandDetail = trackerService.createDemand(emailId, newDemand);
            return ResponseEntity.status(201).body(demandDetail);
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/user/{emailId}/demand")
    public ResponseEntity<Void> updateDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody DemandDetail existingDemand) {
        try {
            trackerService.updateDemand(emailId, existingDemand);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{emailId}/archive")
    public ResponseEntity<Void> archiveDemand(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody List<Long> demandIds) {
        try {
            trackerService.archiveDemand(demandIds);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
