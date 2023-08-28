package com.shahed.instaservice.model;

import com.shahed.instaservice.schema.User;
import lombok.Data;

import java.util.List;

@Data
public class PostModel {
    private Long postId;
    private String caption;
    private String latitude;
    private String longitude;
    private User user;
    private List<PostMediaModel> postMedias;
}
