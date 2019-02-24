package com.tracker.model.invoice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoicetmdtls")
public class InvoiceTMDtls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3919876649620978258L;
	@Id
	private long sow;
	private String po; //unique?
	private String sowStatus;
	private String sowMode;
	private String funcGrp;
	private String dsid;
	private String empLid;
	private String empName;
	private String pu;
	private String multiPurpose;
	private String projId;
	private String allocStrtDt;
	private String endDt;
	private String billAbility;
	private String location;
	private String grade;
	private String projDesc;
	private String avlbPoVlu;
	private String attn;
	private String wrkgDys;
	private String leaveDys;
	private String swipedDys;
	private String swipedHrs;
	private String diffHrs;
	private String wrkDyBilled;
	private String diffDys;
	private String billedHrs;
	private String rate;
	private long billableAmt;
	private String avlblAfterInvoice;
	private String invoiceNo;
	private String subToAppl;
	private String leavDt;
	private String compOff;
	private String ubCityOffc;
	private String wfh;
	private String tempBdgDt;
	private String redFrSwipeMismatch;
	private String remarks;
	
	
	
	public long getSow() {
		return sow;
	}
	public void setSow(long sow) {
		this.sow = sow;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getSowStatus() {
		return sowStatus;
	}
	public void setSowStatus(String sowStatus) {
		this.sowStatus = sowStatus;
	}
	public String getFuncGrp() {
		return funcGrp;
	}
	public void setFuncGrp(String funcGrp) {
		this.funcGrp = funcGrp;
	}
	public String getDsid() {
		return dsid;
	}
	public void setDsid(String dsid) {
		this.dsid = dsid;
	}
	public String getEmpLid() {
		return empLid;
	}
	public void setEmpLid(String empLid) {
		this.empLid = empLid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPu() {
		return pu;
	}
	public void setPu(String pu) {
		this.pu = pu;
	}
	public String getMultiPurpose() {
		return multiPurpose;
	}
	public void setMultiPurpose(String multiPurpose) {
		this.multiPurpose = multiPurpose;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getAllocStrtDt() {
		return allocStrtDt;
	}
	public void setAllocStrtDt(String allocStrtDt) {
		this.allocStrtDt = allocStrtDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getBillAbility() {
		return billAbility;
	}
	public void setBillAbility(String billAbility) {
		this.billAbility = billAbility;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getProjDesc() {
		return projDesc;
	}
	public void setProjDesc(String projDesc) {
		this.projDesc = projDesc;
	}
	public String getAvlbPoVlu() {
		return avlbPoVlu;
	}
	public void setAvlbPoVlu(String avlbPoVlu) {
		this.avlbPoVlu = avlbPoVlu;
	}
	public String getAttn() {
		return attn;
	}
	public void setAttn(String attn) {
		this.attn = attn;
	}
	public String getWrkgDys() {
		return wrkgDys;
	}
	public void setWrkgDys(String wrkgDys) {
		this.wrkgDys = wrkgDys;
	}
	public String getLeaveDys() {
		return leaveDys;
	}
	public void setLeaveDys(String leaveDys) {
		this.leaveDys = leaveDys;
	}
	public String getSwipedDys() {
		return swipedDys;
	}
	public void setSwipedDys(String swipedDys) {
		this.swipedDys = swipedDys;
	}
	public String getDiffHrs() {
		return diffHrs;
	}
	public void setDiffHrs(String diffHrs) {
		this.diffHrs = diffHrs;
	}
	public String getWrkDyBilled() {
		return wrkDyBilled;
	}
	public void setWrkDyBilled(String wrkDyBilled) {
		this.wrkDyBilled = wrkDyBilled;
	}
	public String getDiffDys() {
		return diffDys;
	}
	public void setDiffDys(String diffDys) {
		this.diffDys = diffDys;
	}
	public String getBilledHrs() {
		return billedHrs;
	}
	public void setBilledHrs(String billedHrs) {
		this.billedHrs = billedHrs;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public long getBillableAmt() {
		return billableAmt;
	}
	public void setBillableAmt(long billableAmt) {
		this.billableAmt = billableAmt;
	}
	public String getAvlblAfterInvoice() {
		return avlblAfterInvoice;
	}
	public void setAvlblAfterInvoice(String avlblAfterInvoice) {
		this.avlblAfterInvoice = avlblAfterInvoice;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getSubToAppl() {
		return subToAppl;
	}
	public void setSubToAppl(String subToAppl) {
		this.subToAppl = subToAppl;
	}
	public String getLeavDt() {
		return leavDt;
	}
	public void setLeavDt(String leavDt) {
		this.leavDt = leavDt;
	}
	public String getCompOff() {
		return compOff;
	}
	public void setCompOff(String compOff) {
		this.compOff = compOff;
	}
	public String getUbCityOffc() {
		return ubCityOffc;
	}
	public void setUbCityOffc(String ubCityOffc) {
		this.ubCityOffc = ubCityOffc;
	}
	public String getWfh() {
		return wfh;
	}
	public void setWfh(String wfh) {
		this.wfh = wfh;
	}
	public String getTempBdgDt() {
		return tempBdgDt;
	}
	public void setTempBdgDt(String tempBdgDt) {
		this.tempBdgDt = tempBdgDt;
	}
	public String getRedFrSwipeMismatch() {
		return redFrSwipeMismatch;
	}
	public void setRedFrSwipeMismatch(String redFrSwipeMismatch) {
		this.redFrSwipeMismatch = redFrSwipeMismatch;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSowMode() {
		return sowMode;
	}
	public void setSowMode(String sowMode) {
		this.sowMode = sowMode;
	}
	public String getSwipedHrs() {
		return swipedHrs;
	}
	public void setSwipedHrs(String swipedHrs) {
		this.swipedHrs = swipedHrs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
