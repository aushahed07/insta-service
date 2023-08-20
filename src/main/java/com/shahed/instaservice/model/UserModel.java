package com.shahed.instaservice.model;

import lombok.Data;

@Data
public class UserModel {
    private Long userId;
    private String name;
    private String phoneNumber;
    private String userName;
    private String emailAddress;
    private String userProfilePhoto;
    private String bio;
}
