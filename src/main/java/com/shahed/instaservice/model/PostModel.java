package com.shahed.instaservice.model;

import lombok.Data;

import java.util.List;

@Data
public class PostModel {
    private Long postId;
    private String caption;
    private String latitude;
    private String longitude;
    private Long userId;
    private List<PostMediaModel> postMedias;
}
