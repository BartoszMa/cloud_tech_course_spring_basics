package com.cloud.backend.user.controllers;


import com.cloud.backend.user.model.User;
import com.cloud.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUsers() {
        return ok().body(userService.getAllUsers());
    }


    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody String name) {
        if (userService.findByUsername(name) == null) {
            User newUser = userService.createUser(new User(name));
            return ResponseEntity.status(200).body(newUser);
        }
        return ResponseEntity.status(409).body("User already exist");
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<Object> getUser(@PathVariable String name) {
        if (userService.findByUsername(name) != null) {
            return ResponseEntity.status(200).body(userService.findByUsername(name));
        }
        return ResponseEntity.status(404).body("User doesnt exist");
    }

    @PutMapping("/user/{name}")
    public ResponseEntity<Object> setScore(@PathVariable String name, @RequestBody int newScore) {
        if (userService.findByUsername(name) != null) {
            userService.updateScore(name, newScore);
            return ResponseEntity.status(200).body(userService.findByUsername(name));
        }
        return ResponseEntity.status(404).body("User doesnt exist");
    }

}
