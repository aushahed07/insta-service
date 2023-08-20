package com.shahed.instaservice.schema;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @CreationTimestamp
    private Date createdAt;

    private String caption;

    private String latitude;

    private String longitude;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
