package com.shahed.instaservice.impl;

import com.shahed.instaservice.mapper.PostMapper;
import com.shahed.instaservice.mapper.PostMediaMapper;
import com.shahed.instaservice.mapper.PostMediaTagMapper;
import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.PostMediaModel;
import com.shahed.instaservice.model.PostModel;
import com.shahed.instaservice.repository.PostMediaRepository;
import com.shahed.instaservice.repository.PostMediaTagRepository;
import com.shahed.instaservice.repository.PostRepository;
import com.shahed.instaservice.schema.Post;
import com.shahed.instaservice.schema.PostMedia;
import com.shahed.instaservice.schema.PostMediaTag;
import com.shahed.instaservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    private PostMediaRepository postMediaRepository;
    private PostMediaTagRepository postMediaTagRepository;

    @Override
    public InstaServiceResponse saveOrUpdatePost(PostModel postModel) {
        InstaServiceResponse instaServiceResponse = new InstaServiceResponse();

        if (ObjectUtils.isEmpty(postModel.getPostId()) || postRepository.existsById(postModel.getPostId())) {
            try {
                Post post = PostMapper.modelToEntity(postModel);
                post = postRepository.save(post);
                savePostMedias(postModel, post);

                instaServiceResponse.setHasError(false);
                instaServiceResponse.setMessage("Post information saved successfully");
                instaServiceResponse.setStatus(HttpStatus.CREATED.value());
                instaServiceResponse.setContent(post.getPostId().toString());
            } catch (Exception exception) {
                exception.printStackTrace();
                return new InstaServiceResponse("Failed to save user", exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            instaServiceResponse.setHasError(Boolean.TRUE);
            instaServiceResponse.setMessage("Post information not found, failed to save post");
            instaServiceResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return instaServiceResponse;
    }

    private void savePostMedias(PostModel postModel, Post post) {
        postModel.getPostMedias().forEach(postMediaModel -> {
            postMediaModel.setPost(post);
            PostMedia postMedia = PostMediaMapper.modelToEntity(postMediaModel);
            postMedia = postMediaRepository.save(postMedia);
            savePostMediaTags(postMediaModel, postMedia);
        });
    }

    private void savePostMediaTags(PostMediaModel postMediaModel, PostMedia postMedia) {
        postMediaModel.getPostMediaTags().forEach(postMediaTagModel -> {
            postMediaTagModel.setPostMedia(postMedia);
            PostMediaTag postMediaTag = PostMediaTagMapper.modelToEntity(postMediaTagModel);
            postMediaTagRepository.save(postMediaTag);
        });
    }
}
