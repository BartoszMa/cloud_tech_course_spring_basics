package com.example.backend.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private int score;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }

    public User(String userName) {
        this.userName = userName;
        this.score = 0;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "id: " + id + '\n' + "user: " + userName + '\n' + "score: " + score;
    }
}
