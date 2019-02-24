package com.tracker.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="premiumRate")
public class PremiumRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "premiumRateId")
	private long premiumRateId;

	@Column(name = "premiumRate")
	private String premiumRate;
}
