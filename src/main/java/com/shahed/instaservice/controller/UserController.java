package com.shahed.instaservice.controller;

import com.shahed.instaservice.model.InstaServiceResponse;
import com.shahed.instaservice.model.UserModel;
import com.shahed.instaservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public String greetings(){
        return "Instagram service is running....";
    }

    @GetMapping(value = "/{id}")
    public InstaServiceResponse getUserModelById(@PathVariable Long id){
        return userService.getUserModelById(id);
    }

    @PostMapping()
    public InstaServiceResponse createUser(@RequestBody UserModel userModel){
        return userService.saveOrUpdateUserModel(userModel);
    }


}
