package com.shahed.instaservice.schema;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reactionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
