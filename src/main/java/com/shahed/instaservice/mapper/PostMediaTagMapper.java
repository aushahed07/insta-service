package com.shahed.instaservice.mapper;

import com.shahed.instaservice.model.PostMediaTagModel;
import com.shahed.instaservice.schema.PostMediaTag;

public class PostMediaTagMapper {
    public static PostMediaTag modelToEntity(PostMediaTagModel model) {
        PostMediaTag entity = new PostMediaTag();
        entity.setPostMediaTagId(model.getPostMediaTagId());
        entity.setPostMedia(model.getPostMedia());
        entity.setTaggedUser(model.getTaggedUser());
        entity.setXCoordinate(model.getXCoordinate());
        entity.setYCoordinate(model.getYCoordinate());
        return entity;
    }
}
