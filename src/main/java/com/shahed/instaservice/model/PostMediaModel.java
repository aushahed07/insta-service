package com.shahed.instaservice.model;

import com.shahed.instaservice.schema.Post;
import lombok.Data;
import java.util.List;

@Data
public class PostMediaModel {
    private Long postMediaId;
    private Integer positionInPost;
    private String type;
    private byte[] mediaFile;
    private Post post;
    private List<PostMediaTagModel> postMediaTags;
}
