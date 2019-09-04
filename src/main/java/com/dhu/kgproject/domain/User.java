package com.dhu.kgproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password",nullable = true)
    private String password;
}
