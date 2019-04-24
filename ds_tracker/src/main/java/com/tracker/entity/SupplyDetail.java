package com.tracker.entity;

import com.tracker.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="supplyDetail")
public class SupplyDetail implements Serializable {

	private static final long serialVersionUID = 7554629997735886894L;

	@Id
	@Column(name = "supplyId", nullable = false)
	private String supplyId;

	@Column(name = "candidateName")
	private String candidateName;

	@Column(name = "skillSummary")
	private String skillSummary;

	@Column(name = "status")
	private String status;

	@Column(name = "premiumRate")
	private String premiumRate;

	@Column(name = "recruiterName")
	private String recruiterName;

	@ManyToOne
	@JoinColumn(name = "emailId")
	private User submittedBy;

	@Column(name = "experience")
	private String experienceYear;

	@Column(name = "supplyIntExt")
	private String supplyIntExt;

	@Column(name = "supplyOnOffshore")
	private String supplyOnOffshore;

	@Column(name = "location")
	private String candidateLocation;

	@Column(name = "clientSelectionDate")
	private Date clientSelectionDate;

	@Column(name = "onBoardingDate")
	private Date onBoardingDate;

	@Column(name = "rrNumber")
	private String rrNumber;

	@Column(name = "sfId")
	private String sfId;

	@Column(name = "comments")
	private String comments;

	@Column(name="isArchived")
	private boolean isArchived;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "modifiedDate")
	private Date modifiedDate;

	@ManyToOne
	private User createdBy;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="supplyId")
	private Set<DemandSupplyMapping> demandMappings;

}
