package com.cloud.backend.user.service;

import com.cloud.backend.user.model.User;
import com.cloud.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUser(userName);
    }

    public void updateScore(String userName, Integer newScore) {
        User user = userRepository.findByUser(userName);
        if (user != null) {
            user.setScore(newScore);
            userRepository.save(user);
        }
    }

}
