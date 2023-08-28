package com.shahed.instaservice.model;

import com.shahed.instaservice.schema.PostMedia;
import com.shahed.instaservice.schema.User;
import lombok.Data;

@Data
public class PostMediaTagModel {
    private Long postMediaTagId;
    private User taggedUser;
    private PostMedia postMedia;
    private Double  xCoordinate;
    private Double yCoordinate;
}
