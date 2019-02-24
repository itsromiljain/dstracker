package com.tracker.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8701785440377709563L;
	@Id
	@Column(name="user_id")
	private int id;
	
	/*@Column(name="user_nm")
	@NotBlank
	private String name;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

}
