package com.tracker.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "supplyStatus")
public class SupplyStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplyStatusId")
	public long supplyStatusId;

	@Column(name = "supplyStatus")
	public String supplyStatus;

}
