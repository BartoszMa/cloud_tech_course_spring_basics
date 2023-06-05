package com.cloud.backend.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String user;
    private int score;

    public User(String user) {
        this.user = user;
        this.score = 0;
    }

    public User() {
    }

}
