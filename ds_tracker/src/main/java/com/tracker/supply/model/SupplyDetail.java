package com.tracker.supply.model;

import com.tracker.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="supplyDetail")
public class SupplyDetail implements Serializable {

	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplyId")
	private long supplyId;

	@Column(name = "supplyName")
	private String supplyName;

	@Column(name = "skill")
	private String skill;

	@Column(name = "premiumRate")
	private String premiumRate;

	@Column(name = "recruiterName")
	private String recruiterName;

	@Column(name = "experience")
	private String experienceYear;

	@Column(name = "status")
	private String status;

	@Column(name = "location")
	private String location;

	@Column(name = "intext")
	private String intext;

	@Column(name = "onoffshore")
	private String onoffshore;

	@Column(name = "live")
	private String live;

	@Column(name = "appleInterviewDate")
	private String appleInterviewDate;

	@Column(name = "appleSelectionDate")
	private String appleSelectionDate;

	@Column(name = "onBoardingDate")
	private String onBoardingDate;

	@Column(name = "rrNumber")
	private String rrNumber;

	@Column(name = "sfId")
	private String sfId;

	@Column(name = "description")
	private String description;

	@Column(name="isArchived")
	private boolean isArchived;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "modifiedDate")
	private Date modifiedDate;

	@ManyToOne
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "emailId")
	private User submittedBy;
	
}
