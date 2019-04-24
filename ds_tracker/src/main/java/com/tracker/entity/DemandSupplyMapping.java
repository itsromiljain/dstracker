package com.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "demandSupplyMapping")
public class DemandSupplyMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mappingId", nullable = false)
    private long mappingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="demandId", nullable=false)
    private DemandDetail demand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplyId", nullable=false)
    private SupplyDetail supply;

    @Column(name = "clientInterviewDate")
    private Date clientInterviewDate;

    @Column(name = "interviewLocation")
    private String interviewLocation;

    @Column(name = "selectionStatus")
    private String selectionStatus;

    @Column(name = "remarks")
    private String remarks;

}
