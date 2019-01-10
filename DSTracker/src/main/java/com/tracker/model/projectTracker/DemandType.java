package com.tracker.model.projectTracker;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DemandType  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long demand_type_id;
	public String demandType;

	
	public long getDemand_type_id() {
		return demand_type_id;
	}
	public void setDemand_type_id(long demand_type_id) {
		this.demand_type_id = demand_type_id;
	}
	public String getDemandType() {
		return demandType;
	}
	public void setDemandType(String demandType) {
		this.demandType = demandType;
	}
	

}
