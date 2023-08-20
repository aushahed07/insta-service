package com.shahed.instaservice.schema;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostMediaTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postMediaTagId;

    @ManyToOne
    @JoinColumn(name = "tagged_user_id")
    private User taggedUser;

    @ManyToOne
    @JoinColumn(name = "post_media_id")
    private PostMedia postMedia;

    private Double  xCoordinate;

    private Double yCoordinate;
}
