package com.tracker.model.projectTracker;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demandStatus")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long status_id;
	public String statusType;
	
	
	public long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(long status_id) {
		this.status_id = status_id;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	

}
