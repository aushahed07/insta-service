package com.shahed.instaservice.mapper;

import com.shahed.instaservice.model.UserModel;
import com.shahed.instaservice.schema.User;

public class UserMapper {

    public static User modelToEntity(UserModel model) {
        User entity = new User();
        entity.setUserId(model.getUserId());
        entity.setName(model.getName());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setUserName(model.getUserName());
        entity.setEmailAddress(model.getEmailAddress());
        entity.setUserProfilePhoto(model.getUserProfilePhoto());
        entity.setBio(model.getBio());
        return entity;
    }

    public static UserModel entityToModel(User entity) {
        UserModel model = new UserModel();
        model.setUserId(entity.getUserId());
        model.setName(entity.getName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setUserName(entity.getUserName());
        model.setEmailAddress(entity.getEmailAddress());
        model.setUserProfilePhoto(entity.getUserProfilePhoto());
        model.setBio(entity.getBio());
        return model;
    }

}
