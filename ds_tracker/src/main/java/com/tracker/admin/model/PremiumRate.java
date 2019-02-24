package com.tracker.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PremiumRate")
public class PremiumRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long premiumRateId;
	private String premiumRate;
	public long getPremiumRateId() {
		return premiumRateId;
	}
	public void setPremiumRateId(long premiumRateId) {
		this.premiumRateId = premiumRateId;
	}
	public String getPremiumRate() {
		return premiumRate;
	}
	public void setPremiumRate(String premiumRate) {
		this.premiumRate = premiumRate;
	}
	
}
