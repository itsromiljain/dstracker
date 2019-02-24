package com.tracker.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
@Getter
@Setter
@ToString
@Entity
@Table(name="appleManager")
public class AppleManager implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appleManagerId")
	private long appleManagerId;
	
	
	@Column(name = "appleManagerName")
	private String appleManagerName;

}
