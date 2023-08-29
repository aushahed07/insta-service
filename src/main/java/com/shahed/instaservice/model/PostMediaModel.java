package com.shahed.instaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class PostMediaModel {
    private Long postMediaId;
    private Integer positionInPost;
    private String type;
    private byte[] mediaFile;
    private Long postId;
    private List<PostMediaTagModel> postMediaTags;

    public void setMediaFile(String mediaFile) {
        this.mediaFile = mediaFile.getBytes();
    }
}
