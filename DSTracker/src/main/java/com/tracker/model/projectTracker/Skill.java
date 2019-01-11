package com.tracker.model.projectTracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Skill{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long skill_id;
	private String skill;
	public long getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(long skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	

}
