package com.tracker.demand.pojo;

import com.tracker.supply.pojo.SupplyTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@ToString
public class DemandTO implements Serializable {

    private String demandId;

    private String role;

    private String skills;

    private String additionalSkills;

    private String experience;

    private String demandType;

    private String demandStatus;

    private String priority;

    private String location;

    private String demandOnOffshore;

    private String appleManager;

    private String portfolioAnchor;

    private String suggestedPanel;

    private String jobDescription;

    private String banjoRfr;

    private String oppty;

    private String rrOnshore;

    private String sfOnOffshore;

    private String closureDate;

    private Date createdDate;

    private Date modifiedDate;

    private String createdBy;

    private String submittedBy;

    private boolean isArchived;

    //This collection contains suggestedSupply and Supply selected by the Account Managers
    private Set<SupplyTO> supply;
}
