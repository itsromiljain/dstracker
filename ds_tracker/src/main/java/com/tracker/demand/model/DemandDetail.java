package com.tracker.demand.model;

import com.tracker.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "demandDetail")
public class DemandDetail implements Serializable {

	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demandId")
	private long demandId;
	@Column(name = "rfr")
	private String rfr;
	@Column(name = "oppty")
	private String oppty;
	@Column(name = "rrOnshore")
	private String rrOnshore;
	@Column(name = "demandOnsite")
	private String demandOnsite;
	@Column(name = "demandOffsite")
	private String demandOffsite;
	@Column(name = "location")
	private String location;
	@Column(name = "description")
	private String desc;
	@Column(name = "demandType")
	private String demandType;
	@Column(name = "experience")
	private String experience;
	@Column(name = "priority")
	private String priority;
	@Column(name = "role")
	private String role;
	@Column(name = "suggestedPanel")
	private String suggestedPanel;
	@Column(name = "status")
	private String status;
	@Column(name = "appleManager")
	private String appleManager;
	@Column(name = "recruiter")
	private String recruiter;
	@Column(name = "sf")
	private String sf;
	@Column(name = "skill")
	private String skill;
	@Column(name="isArchived")
	private boolean isArchived;
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
	@Column(name = "suggestedSupply")
	@ElementCollection(targetClass=Integer.class)
	private List<Object> suggestedSupply;

}
