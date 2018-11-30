package com.tracker.model.supply;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="supplydtls")
public class SupplyDtls implements Serializable {

	
	private static final long serialVersionUID = -541714930220574365L;
	@Id
	@Column(name="")
	@NotBlank
	private long psNo;
	@Column(name="")
	@NotBlank
	private String name;
	@Column(name="")
	@NotBlank
	private String skillSmry;
	@Column(name="")
	@NotBlank
	private String buName;
	@Column(name="")
	@NotBlank
	private String on_Off_Shore;
	@Column(name="")
	@NotBlank
	private String int_Ext;
	@Column(name="")
	@NotBlank
	private String status;
	@Column(name="")
	@NotBlank
	private String iviewerNm;
	@Column(name="")
	@NotBlank
	private String intnl_Iview_Cmts;
	@Column(name="")
	@NotBlank
	private String comments;
	@Column(name="")
	@NotBlank
	private String contact;
	@Column(name="")
	@NotBlank
	private String premim_Rate;
	@Column(name="")
	@NotBlank
	private String intrnl_Sub_Dt;
	@Column(name="")
	@NotBlank
	private String appl_Iview_Dt;
	@Column(name="")
	@NotBlank
	private String appl_Sel_Dt;
	@Column(name="")
	@NotBlank
	private String onBord_Dt;
	@Column(name="")
	@NotBlank
	private long dmdId;
	@Column(name="")
	@NotBlank
	private long rrId;
	@Column(name="")
	@NotBlank
	private String pu_Rel_Dt;
	//@Lob
	//private byte[] resume;
	
	
	public long getPsNo() {
		return psNo;
	}
	public void setPsNo(long psNo) {
		this.psNo = psNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkillSmry() {
		return skillSmry;
	}
	public void setSkillSmry(String skillSmry) {
		this.skillSmry = skillSmry;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getOn_Off_Shore() {
		return on_Off_Shore;
	}
	public void setOn_Off_Shore(String on_Off_Shore) {
		this.on_Off_Shore = on_Off_Shore;
	}
	public String getInt_Ext() {
		return int_Ext;
	}
	public void setInt_Ext(String int_Ext) {
		this.int_Ext = int_Ext;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIviewerNm() {
		return iviewerNm;
	}
	public void setIviewerNm(String iviewerNm) {
		this.iviewerNm = iviewerNm;
	}
	public String getIntnl_Iview_Cmts() {
		return intnl_Iview_Cmts;
	}
	public void setIntnl_Iview_Cmts(String intnl_Iview_Cmts) {
		this.intnl_Iview_Cmts = intnl_Iview_Cmts;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPremim_Rate() {
		return premim_Rate;
	}
	public void setPremim_Rate(String premim_Rate) {
		this.premim_Rate = premim_Rate;
	}
	public String getIntrnl_Sub_Dt() {
		return intrnl_Sub_Dt;
	}
	public void setIntrnl_Sub_Dt(String intrnl_Sub_Dt) {
		this.intrnl_Sub_Dt = intrnl_Sub_Dt;
	}
	public String getAppl_Iview_Dt() {
		return appl_Iview_Dt;
	}
	public void setAppl_Iview_Dt(String appl_Iview_Dt) {
		this.appl_Iview_Dt = appl_Iview_Dt;
	}
	public String getAppl_Sel_Dt() {
		return appl_Sel_Dt;
	}
	public void setAppl_Sel_Dt(String appl_Sel_Dt) {
		this.appl_Sel_Dt = appl_Sel_Dt;
	}
	public String getOnBord_Dt() {
		return onBord_Dt;
	}
	public void setOnBord_Dt(String onBord_Dt) {
		this.onBord_Dt = onBord_Dt;
	}
	public long getDmdId() {
		return dmdId;
	}
	public void setDmdId(long dmdId) {
		this.dmdId = dmdId;
	}
	public long getRrId() {
		return rrId;
	}
	public void setRrId(long rrId) {
		this.rrId = rrId;
	}
	public String getPu_Rel_Dt() {
		return pu_Rel_Dt;
	}
	public void setPu_Rel_Dt(String pu_Rel_Dt) {
		this.pu_Rel_Dt = pu_Rel_Dt;
	}
	/*public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}*/
}
