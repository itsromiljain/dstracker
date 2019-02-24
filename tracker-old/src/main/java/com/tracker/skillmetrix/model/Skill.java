package com.tracker.skillmetrix.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="skill")
/*(@NamedQuery(name = "Skill.fetchByPSNumber",
query = "SELECT s.psno FROM Skill s WHERE s.psno  =:psno "
)*/
public class Skill {
	@Id
	private String psno;
    private String buname;
    private String name;
    private String grade;
    private String location;
    private String project_id;
    private String project_name;
    private String project_category;
    private String delivery_manag;
    private String primary_skill;
    private String secondary_skill;
    private String training_attended;
	public String getPsno() {
		return psno;
	}
	public void setPsno(String psno) {
		this.psno = psno;
	}
	public String getBuname() {
		return buname;
	}
	public void setBuname(String buname) {
		this.buname = buname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_category() {
		return project_category;
	}
	public void setProject_category(String project_category) {
		this.project_category = project_category;
	}
	public String getDelivery_manag() {
		return delivery_manag;
	}
	public void setDelivery_manag(String delivery_manag) {
		this.delivery_manag = delivery_manag;
	}
	public String getPrimary_skill() {
		return primary_skill;
	}
	public void setPrimary_skill(String primary_skill) {
		this.primary_skill = primary_skill;
	}
	public String getSecondary_skill() {
		return secondary_skill;
	}
	public void setSecondary_skill(String secondary_skill) {
		this.secondary_skill = secondary_skill;
	}
	public String getTraining_attended() {
		return training_attended;
	}
	public void setTraining_attended(String training_attended) {
		this.training_attended = training_attended;
	}   
}
