package com.vcon.v1.apis.dao;

import com.vcon.v1.apis.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
// You can define custom queries here if necessary
}