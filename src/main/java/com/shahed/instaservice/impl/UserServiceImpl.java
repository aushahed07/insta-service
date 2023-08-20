package com.shahed.instaservice.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shahed.instaservice.mapper.UserMapper;
import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.UserModel;
import com.shahed.instaservice.repository.UserRepository;
import com.shahed.instaservice.schema.User;
import com.shahed.instaservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public InstaServiceResponse getUserModelById(Long userId) {

        InstaServiceResponse instaServiceResponse = new InstaServiceResponse();
        ObjectMapper mapper = new ObjectMapper();
        User user = userRepository.getByUserId(userId).orElse(null);
        if (!ObjectUtils.isEmpty(user)) {
            try {
                UserModel userModel = UserMapper.entityToModel(user);
                instaServiceResponse.setHasError(false);
                instaServiceResponse.setMessage("User information found successfully.");
                instaServiceResponse.setStatus(HttpStatus.OK.value());
                instaServiceResponse.setContent(mapper.writeValueAsString(userModel));
            } catch (Exception exception) {
                exception.printStackTrace();
                return new InstaServiceResponse("Failed to get user information.", HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            instaServiceResponse.setHasError(Boolean.TRUE);
            instaServiceResponse.setMessage("User information not found.");
            instaServiceResponse.setStatus(HttpStatus.OK.value());
        }
        return instaServiceResponse;
    }

    @Override
    public InstaServiceResponse saveOrUpdateUserModel(UserModel userModel) {

        InstaServiceResponse instaServiceResponse = new InstaServiceResponse();

        if (ObjectUtils.isEmpty(userModel.getUserId()) || userRepository.existsById(userModel.getUserId())) {
            User user = UserMapper.modelToEntity(userModel);
            try {
                user = userRepository.save(user);
            } catch (Exception exception) {
                exception.printStackTrace();
                return new InstaServiceResponse("Failed to save user", exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
            instaServiceResponse.setHasError(false);
            instaServiceResponse.setMessage("User information saved successfully");
            instaServiceResponse.setStatus(HttpStatus.CREATED.value());
            instaServiceResponse.setContent(user.getUserId().toString());
        } else {
            instaServiceResponse.setHasError(Boolean.TRUE);
            instaServiceResponse.setMessage("User information not found, failed to save user");
            instaServiceResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        return instaServiceResponse;
    }
}
