package com.tracker.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @Column(name = "emailId")
    private String emailId;

    @Column(name = "hashCode")
    private String hashCode;

    @Column(name = "salt")
    private String salt;

    @Column(name = "userCategory")
    private String userCategory;

}
