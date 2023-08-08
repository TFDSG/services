package com.diyo.app.authApp.controller;

import com.diyo.app.authApp.entity.User;
import com.diyo.app.authApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody User user){
        String result = userService.validateUserLogin(user);
        return result;
    }
    @PostMapping(value = "/signup")
    public String signUp(@RequestBody User user){
        String result = userService.validateUserSignup(user);
        return result;
    }
}
