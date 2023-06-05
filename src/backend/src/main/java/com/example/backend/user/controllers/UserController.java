package com.example.backend.user.controllers;

import com.example.backend.user.model.User;
import com.example.backend.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping(value = "/")
    public List<User> fetchAllUsers() {
        return userService.getAllUsers();
    }
}
