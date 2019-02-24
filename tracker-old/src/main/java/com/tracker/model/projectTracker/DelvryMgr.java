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
@Table(name = "Delvrymgr")
public class DelvryMgr implements Serializable {

	private static final long serialVersionUID = 3556011590435982372L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DMNGR_ID")
	private long dmngr_id;
	@Column(name = "DMNGR_NM")
	private String dmngr_name;
	/*@OneToMany(mappedBy = "delvryMgr")
	private List<ProjTrakr> projtrakr;

	public List<ProjTrakr> getProjTrakr() {
		return projtrakr;
	}

	public void setProjTrakr(List<ProjTrakr> projtrakr) {
		this.projtrakr = projtrakr;
	}*/

	public String getDmngr_name() {
		return dmngr_name;
	}

	public long getDmngr_id() {
		return dmngr_id;
	}

	public void setDmngr_id(long dmngr_id) {
		dmngr_id = dmngr_id;
	}

	public void setDmngr_name(String dmngr_name) {
		dmngr_name = dmngr_name;
	}
}
