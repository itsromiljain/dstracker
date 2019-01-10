package com.tracker.model.projectTracker;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Projtrakr")
public class ProjTrakr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demandid")
	private long id;
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
	@Column(name = "yrOfExp")
	private String yrOfExp;
	@Column(name = "priority")
	private String priority;
	@Column(name = "role")
	private String role;
	@Column(name = "suggestedPanel")
	private String suggestedPanel;
	@Column(name = "status")
	private String status;
	@Column(name = "closureDate")
	private String closureDate;
	@Column(name = "applel2manager")
	private String applel2manager;
	@Column(name = "recruiter")
	private String recruiter;
	@Column(name = "sf")
	private String sf;
	@Column(name = "skill")
	private String skill;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRfr() {
		return rfr;
	}

	public void setRfr(String rfr) {
		this.rfr = rfr;
	}

	public String getOppty() {
		return oppty;
	}

	public void setOppty(String oppty) {
		this.oppty = oppty;
	}

	public String getRrOnshore() {
		return rrOnshore;
	}

	public void setRrOnshore(String rrOnshore) {
		this.rrOnshore = rrOnshore;
	}

	public String getDemandOnsite() {
		return demandOnsite;
	}

	public void setDemandOnsite(String demandOnsite) {
		this.demandOnsite = demandOnsite;
	}

	public String getDemandOffsite() {
		return demandOffsite;
	}

	public void setDemandOffsite(String demandOffsite) {
		this.demandOffsite = demandOffsite;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDemandType() {
		return demandType;
	}

	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}

	public String getYrOfExp() {
		return yrOfExp;
	}

	public void setYrOfExp(String yrOfExp) {
		this.yrOfExp = yrOfExp;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSuggestedPanel() {
		return suggestedPanel;
	}

	public void setSuggestedPanel(String suggestedPanel) {
		this.suggestedPanel = suggestedPanel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(String closureDate) {
		this.closureDate = closureDate;
	}

	public String getApplel2manager() {
		return applel2manager;
	}

	public void setApplel2manager(String applel2manager) {
		this.applel2manager = applel2manager;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
