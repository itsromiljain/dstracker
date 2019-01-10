package com.tracker.model.projectTracker;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="appleL2Manager")
public class AppleManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appleL2MNGR_ID")
	private long applel2mngr_id;
	
	
	@Column(name = "appleL2MNGR_NM")
	private String applel2mngr_name;

	public long getApplel2mngr_id() {
		return applel2mngr_id;
	}

	public void setApplel2mngr_id(long applel2mngr_id) {
		this.applel2mngr_id = applel2mngr_id;
	}

	public String getApplel2mngr_name() {
		return applel2mngr_name;
	}

	public void setApplel2mngr_name(String applel2mngr_name) {
		this.applel2mngr_name = applel2mngr_name;
	}
	
	
	

}
