package com.tracker.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SupplyStatus")
public class SupplyStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long supplyStatusId;
	public String supplyStatus;

	public long getSupplyStatusId() {
		return supplyStatusId;
	}

	public void setSupplyStatusId(long supplyStatusId) {
		this.supplyStatusId = supplyStatusId;
	}

	public String getSupplyStatus() {
		return supplyStatus;
	}

	public void setSupplyStatus(String supplyStatus) {
		this.supplyStatus = supplyStatus;
	}

}
