package com.shahed.instaservice.schema;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postMediaId;

    private Integer positionInPost;

    private String type;

    @Lob
    private byte[] mediaFile;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
