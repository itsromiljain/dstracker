package com.tracker.entity;

import com.tracker.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "demandDetail")
public class DemandDetail implements Serializable {

	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@Column(name = "demandId", nullable = false)
	private String demandId;

	@Column(name = "role")
	private String role;

	@Column(name = "skills")
	private String skills;

	@Column(name = "additionalSkills")
	private String additionalSkills;

	@Column(name = "experience")
	private String experience;

	@Column(name = "demandType")
	private String demandType;

	@Column(name = "demandStatus")
	private String demandStatus;

	@Column(name = "priority")
	private String priority;

	@Column(name = "location")
	private String location;

	@Column(name = "demandOnOffshore")
	private String demandOnOffshore;

	@Column(name = "appleManager")
	private String appleManager;

	@Column(name = "portfolioAnchor")
	private String portfolioAnchor;

	@Column(name = "suggestedPanel")
	private String suggestedPanel;

	@Column(name = "jobDescription")
	private String jobDescription;

	@Column(name = "banjoRfr")
	private String banjoRfr;

	@Column(name = "oppty")
	private String oppty;

	@Column(name = "rrOnOffshore")
	private String rrOnshore;

	@Column(name = "sfOnOffshore")
	private String sfOnOffshore;

	@Column(name = "closureDate")
	private String closureDate;

	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "modifiedDate")
	private Date modifiedDate;

	@ManyToOne
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "emailId")
	private User submittedBy;

	@Column(name="isArchived")
	private boolean isArchived;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="demandId")
	private Set<DemandSupplyMapping> supplyMappings;

}
