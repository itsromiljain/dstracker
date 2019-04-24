package com.tracker.supply.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
public class SupplyMappingTO implements Serializable {

    private Long mappingId;

    private String demandId;

    private Date clientInterviewDate;

    private String interviewLocation;

    private String selectionStatus;

    private String remarks;
}
