package com.shahed.instaservice.controller;

import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.PostModel;
import com.shahed.instaservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public InstaServiceResponse createPost(@RequestBody PostModel postModel){
        return postService.saveOrUpdatePost(postModel);
    }

    @GetMapping(value = "/{id}")
    public InstaServiceResponse updatePost(@RequestParam() Long id, @RequestBody PostModel postModel){
        return postService.updatePost(id, postModel);
    }
}
