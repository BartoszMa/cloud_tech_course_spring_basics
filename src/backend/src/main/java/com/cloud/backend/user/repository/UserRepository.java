package com.cloud.backend.user.repository;

import com.cloud.backend.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUser(String userName);
}
