package com.example.backend.user.service;

import com.example.backend.user.model.User;
import com.example.backend.user.repository.UserRepository;
//import com.example.backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
