package com.shahed.instaservice.service;

import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    InstaServiceResponse getUserModelById(Long userId);

    InstaServiceResponse saveOrUpdateUserModel(UserModel userModel);
}
