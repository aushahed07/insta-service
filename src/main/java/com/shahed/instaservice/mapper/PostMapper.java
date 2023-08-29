package com.shahed.instaservice.mapper;

import com.shahed.instaservice.model.PostModel;
import com.shahed.instaservice.schema.Post;
import com.shahed.instaservice.schema.User;

public class PostMapper {

    public static Post modelToEntity(PostModel model) {
        Post entity = new Post();
        entity.setPostId(model.getPostId());
        entity.setCaption(model.getCaption());
        entity.setLatitude(model.getLatitude());
        entity.setLongitude(model.getLongitude());
        entity.setUser(new User());
        entity.getUser().setUserId(model.getUserId());
        return entity;
    }
}
