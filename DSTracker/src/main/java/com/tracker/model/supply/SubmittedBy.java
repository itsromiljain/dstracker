package com.tracker.model.supply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="submittedBy")
public class SubmittedBy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long submittedById;
	private String submittedBy;
	public long getSubmittedById() {
		return submittedById;
	}
	public void setSubmittedById(long submittedById) {
		this.submittedById = submittedById;
	}
	public String getSubmittedBy() {
		return submittedBy;
	}
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	

}
