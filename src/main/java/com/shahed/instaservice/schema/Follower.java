package com.shahed.instaservice.schema;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long followerId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_user_id")
    private User follower;

}
