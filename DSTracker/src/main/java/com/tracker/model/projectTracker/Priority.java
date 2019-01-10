package com.tracker.model.projectTracker;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="priority")
public class Priority implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long priority_id;
	public String priority;
	
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public long getPriority_id() {
		return priority_id;
	}
	public void setPriority_id(long priority_id) {
		this.priority_id = priority_id;
	}

	}
	


