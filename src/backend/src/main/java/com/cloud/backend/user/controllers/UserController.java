package com.cloud.backend.user.controllers;


import com.cloud.backend.user.model.User;
import com.cloud.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping( "/user")
    public ResponseEntity<List<User>> fetchAllUsers() {
        return ok().body(userService.getAllUsers());
    }


    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody String name) {
        try {
            userService.findByUsername(name);
            User newUser = userService.createUser(new User(name));
            return ResponseEntity.status(200).body(newUser);
        } catch (Exception error) {
            return ResponseEntity.status(409).body("User already exist");
        }
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name) {
        return ResponseEntity.status(200).body(userService.findByUsername(name));
    }

}
