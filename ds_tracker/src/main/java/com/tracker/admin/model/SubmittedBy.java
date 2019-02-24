package com.tracker.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="submittedBy")
public class SubmittedBy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "submittedById")
	private long submittedById;

	@Column(name = "submittedBy")
	private String submittedBy;
}
