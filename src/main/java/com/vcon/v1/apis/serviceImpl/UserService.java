package com.vcon.v1.apis.serviceImpl;
import com.vcon.v1.apis.dao.UserRepository;
import com.vcon.v1.apis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get a user by ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}
