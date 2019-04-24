package com.tracker.supply.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class SupplyTO implements Serializable {


    private String supplyId;

    private String candidateName;

    private String skillSummary;

    private String candidateStatus;

    private String premiumRate;

    private String recruiterName;

    private String submittedBy;

    private String experienceYear;

    private String supplyIntExt;

    private String supplyOnOffshore;

    private String candidateLocation;

    private String clientSelectionDate;

    private Date onBoardingDate;

    private String rrNumber;

    private String sfId;

    private String comments;

    private boolean isArchived = false;

    private Date createdDate;

    private Date modifiedDate;

    private String createdBy;

    private boolean isMapped = false;

    private List<SupplyMappingTO> supplyMapping;

}
