package com.shahed.instaservice.service;

import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.PostModel;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    InstaServiceResponse saveOrUpdatePost(PostModel postModel);
}
