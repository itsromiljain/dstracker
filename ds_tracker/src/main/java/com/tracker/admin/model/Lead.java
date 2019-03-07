package com.tracker.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "leads")
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leadId")
	private long leadId;

	@Column(name = "leadValue")
	private String leadValue;
}
