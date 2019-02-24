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
@Table(name="priority")
public class Priority implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "priotiryId")
	public long priorityId;

	@Column(name = "priority")
	public String priority;


}
	


