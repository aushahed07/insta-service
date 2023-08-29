package com.shahed.instaservice.model;

import lombok.Data;

@Data
public class PostMediaTagModel {
    private Long postMediaTagId;
    private Long taggedUserId;
    private Long postMediaId;
    private Double  xCoordinate;
    private Double yCoordinate;
}
