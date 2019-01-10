package com.tracker.model.projectTracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yrOfExp")
public class YrOfExp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String yrOfExp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getYrOfExp() {
		return yrOfExp;
	}
	public void setYrOfExp(String yrOfExp) {
		this.yrOfExp = yrOfExp;
	}

	
	
}
