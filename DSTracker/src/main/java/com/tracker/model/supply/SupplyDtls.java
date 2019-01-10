package com.tracker.model.supply;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplydtls")
public class SupplyDtls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7554629997735886894L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplyid")
	private long id;
	private String supplyname;
	private String skill;
	private String demandid;
	private String premiumrate;
	private String recruitername;
	private String submittedby;
	private String yrofexp;
	private String status;
	private String location;
	private String intext;
	private String onoffshore;
	private String live;
	private String modifieddate;
	private String appleinterviewdate;
	private String appleselectiondate;
	private String onboardingdate;
	private String rrnumber;
	private String sfid;
	@Column(name = "description")
	private String desc;
//	private String fileName;
//	private String fileType;
//	@Lob
//	private byte[] data;
	
	public SupplyDtls() {		
	}
//	  public SupplyDtls(long id,String supplyname,String skill,String demandid,
//			  String premiumrate,String recruitername,String submittedby,String yrofexp,
//			  String status,String location,String intext,String onoffshore,String live,
//			  String modifieddate,String appleinterviewdate,String appleselectiondate,
//			  String onboardingdate,String rrnumber,String sfid,String desc,String fileName, String fileType, byte[] data) {
//		  this.id = id;
//		  this.supplyname = supplyname;
//		  this.skill = skill;
//		  this.demandid = demandid;
//		  this.premiumrate = premiumrate;
//		  this.recruitername = recruitername;
//		  this.submittedby = submittedby;
//		  this.yrofexp = yrofexp;
//		  this.status = status;
//		  this.location = location;
//		  this.intext = intext;
//		  this.onoffshore = onoffshore;
//		  this.live = live;
//		  this.modifieddate = modifieddate;
//		  this.appleinterviewdate = appleinterviewdate;
//		  this.appleselectiondate = appleselectiondate;
//		  this.onboardingdate = onboardingdate;
//		  this.rrnumber = rrnumber;
//		  this.sfid = sfid;
//		  this.desc = desc;
//		  this.fileName = fileName;
//	        this.fileType = fileType;
//	        this.data = data;
//	    }  
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getFileType() {
//		return fileType;
//	}
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}
//	public byte[] getData() {
//		return data;
//	}
//	public void setData(byte[] data) {
//		this.data = data;
//	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSupplyname() {
		return supplyname;
	}
	public void setSupplyname(String supplyname) {
		this.supplyname = supplyname;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getDemandid() {
		return demandid;
	}
	public void setDemandid(String demandid) {
		this.demandid = demandid;
	}
	public String getPremiumrate() {
		return premiumrate;
	}
	public void setPremiumrate(String premiumrate) {
		this.premiumrate = premiumrate;
	}
	public String getRecruitername() {
		return recruitername;
	}
	public void setRecruitername(String recruitername) {
		this.recruitername = recruitername;
	}
	public String getSubmittedby() {
		return submittedby;
	}
	public void setSubmittedby(String submittedby) {
		this.submittedby = submittedby;
	}
	public String getYrofexp() {
		return yrofexp;
	}
	public void setYrofexp(String yrofexp) {
		this.yrofexp = yrofexp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIntext() {
		return intext;
	}
	public void setIntext(String intext) {
		this.intext = intext;
	}
	public String getOnoffshore() {
		return onoffshore;
	}
	public void setOnoffshore(String onoffshore) {
		this.onoffshore = onoffshore;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getAppleinterviewdate() {
		return appleinterviewdate;
	}
	public void setAppleinterviewdate(String appleinterviewdate) {
		this.appleinterviewdate = appleinterviewdate;
	}
	public String getAppleselectiondate() {
		return appleselectiondate;
	}
	public void setAppleselectiondate(String appleselectiondate) {
		this.appleselectiondate = appleselectiondate;
	}
	public String getOnboardingdate() {
		return onboardingdate;
	}
	public void setOnboardingdate(String onboardingdate) {
		this.onboardingdate = onboardingdate;
	}
	public String getRrnumber() {
		return rrnumber;
	}
	public void setRrnumber(String rrnumber) {
		this.rrnumber = rrnumber;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
