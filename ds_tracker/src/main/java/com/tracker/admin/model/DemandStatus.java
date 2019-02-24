package com.tracker.admin.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="demandStatus")
public class DemandStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "statusId")
	public long statusId;

	@Column(name = "statusType")
	public String statusType;
}
