package com.shahed.instaservice.impl;

import com.shahed.instaservice.mapper.PostMapper;
import com.shahed.instaservice.mapper.PostMediaMapper;
import com.shahed.instaservice.mapper.PostMediaTagMapper;
import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.PostMediaModel;
import com.shahed.instaservice.model.PostMediaTagModel;
import com.shahed.instaservice.model.PostModel;
import com.shahed.instaservice.repository.PostMediaRepository;
import com.shahed.instaservice.repository.PostMediaTagRepository;
import com.shahed.instaservice.repository.PostRepository;
import com.shahed.instaservice.repository.UserRepository;
import com.shahed.instaservice.schema.Post;
import com.shahed.instaservice.schema.PostMedia;
import com.shahed.instaservice.schema.PostMediaTag;
import com.shahed.instaservice.schema.User;
import com.shahed.instaservice.service.PostService;
import jdk.internal.org.jline.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.logging.Logger;

@Service
public class PostServiceImpl implements PostService {

    private final Logger logger = Logger.getLogger(PostServiceImpl.class.getName());

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMediaRepository postMediaRepository;
    @Autowired
    private PostMediaTagRepository postMediaTagRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public InstaServiceResponse saveOrUpdatePost(PostModel postModel) {
        InstaServiceResponse instaServiceResponse = new InstaServiceResponse();

        if (ObjectUtils.isEmpty(postModel.getPostId()) || postModel.getPostId() == 0 || postRepository.existsById(postModel.getPostId())) {
            try {
                User user = userRepository.getByUserId(postModel.getUserId()).orElse(null);
                if(ObjectUtils.isEmpty(user)) {
                    String message = "User information not found!";
                    logger.info(message + " userId: " + postModel.getUserId());
                    return new InstaServiceResponse(message, 404);
                }

                Post post = PostMapper.modelToEntity(postModel);
                post = postRepository.save(post);
                postModel.setPostId(post.getPostId());
                savePostMedias(postModel);

                instaServiceResponse.setHasError(false);
                instaServiceResponse.setMessage("Post information saved successfully");
                instaServiceResponse.setStatus(HttpStatus.CREATED.value());
                instaServiceResponse.setContent(post.getPostId().toString());
            } catch (Exception exception) {
                exception.printStackTrace();
                return new InstaServiceResponse("Failed to save post", exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            instaServiceResponse.setHasError(Boolean.TRUE);
            instaServiceResponse.setMessage("Post information not found, failed to save post");
            instaServiceResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return instaServiceResponse;
    }

    @Override
    public InstaServiceResponse updatePost(Long id, PostModel postModel) {
        if(ObjectUtils.isEmpty(id) || id <= 0 || !postRepository.existsById(id)) {
            return new InstaServiceResponse("Invalid post.", 400);
        }
        postModel.setPostId(id);
        return saveOrUpdatePost(postModel);
    }

    private void savePostMedias(PostModel postModel) throws Exception {
        for (PostMediaModel postMediaModel : postModel.getPostMedias()) {
            postMediaModel.setPostId(postModel.getPostId());
            PostMedia postMedia = PostMediaMapper.modelToEntity(postMediaModel);
            postMedia = postMediaRepository.save(postMedia);
            postMediaModel.setPostMediaId(postMedia.getPostMediaId());
            savePostMediaTags(postMediaModel);
        }
    }

    private void savePostMediaTags(PostMediaModel postMediaModel) throws Exception{
        for (PostMediaTagModel postMediaTagModel : postMediaModel.getPostMediaTags()) {
            User user = userRepository.getByUserId(postMediaTagModel.getTaggedUserId()).orElse(null);
            if (ObjectUtils.isEmpty(user)) {
                String message = "Tagged user information not found!";
                logger.info(message + " userId: " + postMediaTagModel.getTaggedUserId());
                throw new Exception();
            }
            postMediaTagModel.setPostMediaId(postMediaModel.getPostMediaId());
            PostMediaTag postMediaTag = PostMediaTagMapper.modelToEntity(postMediaTagModel);
            postMediaTagRepository.save(postMediaTag);
        }
    }
}
