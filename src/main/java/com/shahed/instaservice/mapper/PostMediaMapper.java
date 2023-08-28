package com.shahed.instaservice.mapper;

import com.shahed.instaservice.model.PostMediaModel;
import com.shahed.instaservice.schema.PostMedia;

public class PostMediaMapper {
    public static PostMedia modelToEntity(PostMediaModel model) {
        PostMedia entity = new PostMedia();
        entity.setPostMediaId(model.getPostMediaId());
        entity.setPost(model.getPost());
        entity.setMediaFile(model.getMediaFile());
        entity.setPositionInPost(model.getPositionInPost());
        entity.setType(model.getType());
        return entity;
    }
}
