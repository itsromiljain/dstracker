package com.tracker.model.projectTracker;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Imt")
public class Imt implements Serializable {

	private static final long serialVersionUID = 804009965843050211L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMT_ID")
	private long imt_id;
	@Column(name="IMT_NM")
	private String imt_name;
	/*@OneToMany(mappedBy = "imt")
	private List<ProjTrakr> projTrakr;
	
	
	public List<ProjTrakr> getProjTrakr() {
		return projTrakr;
	}
	public void setProjTrakr(List<ProjTrakr> projTrakr) {
		this.projTrakr = projTrakr;
	}*/
	public String getImt_name() {
		return imt_name;
	}
	public long getImt_id() {
		return imt_id;
	}
	public void setImt_id(long imt_id) {
		this.imt_id = imt_id;
	}
	public void setImt_name(String imt_name) {
		this.imt_name = imt_name;
	}

}
