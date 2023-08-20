package com.shahed.instaservice.schema;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String emailAddress;

    private String userProfilePhoto;

    private String bio;
}
