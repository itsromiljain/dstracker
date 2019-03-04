package com.tracker.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @Transient
    private String password;

    @Column(name = "hashCode")
    private String encryptedPassword;

    @Column(name = "token")
    private String token;

    @Column(name = "role")
    private String role;

    @Column(name = "active")
    private Boolean active = true;
}
