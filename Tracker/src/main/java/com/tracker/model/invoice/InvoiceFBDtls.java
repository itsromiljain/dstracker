package com.tracker.model.invoice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoicefbdtls")
public class InvoiceFBDtls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1933772187881732766L;
	
	
	private long formNo; //clarification unique?
	private String amt;
	private String funcGrp;
	@Id
	private long poNo;
	private String poTitle;
	private String poVlu;
	private String poStrtDt;
	private String poEndDt;
	private String buCntctNm;
	private String milestone; // as per month , so we can add seperate month drop down in UI?
	private String invoiceNo;
	
	public long getFormNo() {
		return formNo;
	}
	public void setFormNo(long formNo) {
		this.formNo = formNo;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getFuncGrp() {
		return funcGrp;
	}
	public void setFuncGrp(String funcGrp) {
		this.funcGrp = funcGrp;
	}
	public long getPoNo() {
		return poNo;
	}
	public void setPoNo(long poNo) {
		this.poNo = poNo;
	}
	public String getPoTitle() {
		return poTitle;
	}
	public void setPoTitle(String poTitle) {
		this.poTitle = poTitle;
	}
	public String getPoVlu() {
		return poVlu;
	}
	public void setPoVlu(String poVlu) {
		this.poVlu = poVlu;
	}
	public String getPoStrtDt() {
		return poStrtDt;
	}
	public void setPoStrtDt(String poStrtDt) {
		this.poStrtDt = poStrtDt;
	}
	public String getPoEndDt() {
		return poEndDt;
	}
	public void setPoEndDt(String poEndDt) {
		this.poEndDt = poEndDt;
	}
	public String getBuCntctNm() {
		return buCntctNm;
	}
	public void setBuCntctNm(String buCntctNm) {
		this.buCntctNm = buCntctNm;
	}
	public String getMilestone() {
		return milestone;
	}
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
