package com.tracker.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="demandType")
public class DemandType  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "demandTypeId")
	public long demandTypeId;

	@Column(name = "demandType")
	public String demandType;
}
