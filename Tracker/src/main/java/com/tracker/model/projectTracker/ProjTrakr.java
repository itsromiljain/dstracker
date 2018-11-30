package com.tracker.model.projectTracker;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Projtrakr")
public class ProjTrakr implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJ_ID")
	private long id;
	@Column(name = "PFOLIO_NM")
	private String portfolio;
	@Column(name = "PROJ_NM")
	private String project;
	@Column(name = "PROJ_DESC")
	// @Lob
	private String desc;
	@Column(name = "FNL_DELIVERY")
	private String live;// onyl date
	@Column(name = "NXT_MSTONE")
	private String milestone;
	@Column(name = "NXT_MSTONE_DDAT") // clarification
	private String milestonedate;// clarification
	@Column(name = "PROJ_STATS")
	private String status;
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "IMT_ID")
	//private Imt imt;
	 @Column(name ="IMT_DTLS")
	 private String imt;
	@Column(name = "APPL_MNGR")
	private String applemanager;
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "DMNGR_ID")
	//private DelvryMgr delvryMgr;
	@Column(name ="DMNGR_DTLS")
	private String deliverymanager;
	@Column(name = "LTI_MNGD")
	private String ltimanaged;
	@Column(name = "LTI_ONST_LEAD")
	private String ltionsitelead;
	@Column(name = "LTI_OFSHR_LEAD")
	private String offshorelead;
	@Column(name = "OVRAL_TEAMS")
	private int overallsize;
	@Column(name = "LTI_ONST_TEAMS")
	private int ltionsitesize;
	@Column(name = "LTI_OFSHR_TEAMS")
	private int ltioffshoresize;
	@Column(name = "LTI_OFSHR_TEAM_MEM")
	private String ltioffshoreteam;
	@Column(name = "OTHER_VENDORS")
	private String othervendors;
	@Column(name = "SHIFT_TIM")
	private String shifttime; // clarification
	@Column(name = "CLNT_APPRCTN")
	private String appreciation;
	@Column(name = "ESCALATION")
	// @Lob
	private String issues;
	@Column(name = "MITIGATION")
	// @Lob
	private String mitigation;
	@Column(name = "STATS_ISSUE")
	// @Lob
	private String issuemitigation;
	@Column(name = "REMARKS")
	// @Lob
	private String remarks;
	@Column(name = "INDCTN_KIT")
	private String induction;
	@Column(name = "WKLY_STATS_CLNT")
	private String weeklystatus;
	@Column(name = "IMT_NAME")
	private String imtName;
	@Column(name = "DM_NAME")
	private String dmName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}
	public String getMilestone() {
		return milestone;
	}
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	public String getMilestonedate() {
		return milestonedate;
	}
	public void setMilestonedate(String milestonedate) {
		this.milestonedate = milestonedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImt() {
		return imt;
	}
	public void setImt(String imt) {
		this.imt = imt;
	}
	public String getApplemanager() {
		return applemanager;
	}
	public void setApplemanager(String applemanager) {
		this.applemanager = applemanager;
	}
	public String getDeliverymanager() {
		return deliverymanager;
	}
	public void setDeliverymanager(String deliverymanager) {
		this.deliverymanager = deliverymanager;
	}
	public String getLtimanaged() {
		return ltimanaged;
	}
	public void setLtimanaged(String ltimanaged) {
		this.ltimanaged = ltimanaged;
	}
	public String getLtionsitelead() {
		return ltionsitelead;
	}
	public void setLtionsitelead(String ltionsitelead) {
		this.ltionsitelead = ltionsitelead;
	}
	public String getOffshorelead() {
		return offshorelead;
	}
	public void setOffshorelead(String offshorelead) {
		this.offshorelead = offshorelead;
	}
	public int getOverallsize() {
		return overallsize;
	}
	public void setOverallsize(int overallsize) {
		this.overallsize = overallsize;
	}
	public int getLtionsitesize() {
		return ltionsitesize;
	}
	public void setLtionsitesize(int ltionsitesize) {
		this.ltionsitesize = ltionsitesize;
	}
	public int getLtioffshoresize() {
		return ltioffshoresize;
	}
	public void setLtioffshoresize(int ltioffshoresize) {
		this.ltioffshoresize = ltioffshoresize;
	}
	public String getLtioffshoreteam() {
		return ltioffshoreteam;
	}
	public void setLtioffshoreteam(String ltioffshoreteam) {
		this.ltioffshoreteam = ltioffshoreteam;
	}
	public String getOthervendors() {
		return othervendors;
	}
	public void setOthervendors(String othervendors) {
		this.othervendors = othervendors;
	}
	public String getShifttime() {
		return shifttime;
	}
	public void setShifttime(String shifttime) {
		this.shifttime = shifttime;
	}
	public String getAppreciation() {
		return appreciation;
	}
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	public String getIssues() {
		return issues;
	}
	public void setIssues(String issues) {
		this.issues = issues;
	}
	public String getMitigation() {
		return mitigation;
	}
	public void setMitigation(String mitigation) {
		this.mitigation = mitigation;
	}
	public String getIssuemitigation() {
		return issuemitigation;
	}
	public void setIssuemitigation(String issuemitigation) {
		this.issuemitigation = issuemitigation;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getInduction() {
		return induction;
	}
	public void setInduction(String induction) {
		this.induction = induction;
	}
	public String getWeeklystatus() {
		return weeklystatus;
	}
	public void setWeeklystatus(String weeklystatus) {
		this.weeklystatus = weeklystatus;
	}
	public String getImtName() {
		return imtName;
	}
	public void setImtName(String imtName) {
		this.imtName = imtName;
	}
	public String getDmName() {
		return dmName;
	}
	public void setDmName(String dmName) {
		this.dmName = dmName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
