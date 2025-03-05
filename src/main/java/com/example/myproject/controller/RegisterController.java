package com.example.myproject.controller;

import com.example.myproject.model.Message;
import com.example.myproject.model.Users;
import com.example.myproject.repository.UserRepo;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping
    public Message registerUser(@RequestBody Users user){
        userService.registerUser(user.getUsername(), user.getPassword());
        return new Message("User registered Successfully");
    }


}
