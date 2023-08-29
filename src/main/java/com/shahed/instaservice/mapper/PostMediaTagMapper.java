package com.shahed.instaservice.mapper;

import com.shahed.instaservice.model.PostMediaTagModel;
import com.shahed.instaservice.schema.PostMedia;
import com.shahed.instaservice.schema.PostMediaTag;
import com.shahed.instaservice.schema.User;

public class PostMediaTagMapper {
    public static PostMediaTag modelToEntity(PostMediaTagModel model) {
        PostMediaTag entity = new PostMediaTag();
        entity.setPostMediaTagId(model.getPostMediaTagId());
        entity.setPostMedia(new PostMedia());
        entity.getPostMedia().setPostMediaId(model.getPostMediaId());
        entity.setTaggedUser(new User());
        entity.getTaggedUser().setUserId(model.getTaggedUserId());
        entity.setXCoordinate(model.getXCoordinate());
        entity.setYCoordinate(model.getYCoordinate());
        return entity;
    }
}
