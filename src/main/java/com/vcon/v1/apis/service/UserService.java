package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username); // Added for consistency
}