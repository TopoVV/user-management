package com.topov.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String birthDate;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String about;
    //private Address address;
}
