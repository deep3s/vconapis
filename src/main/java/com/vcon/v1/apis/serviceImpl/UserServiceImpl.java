
package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.entity.User;
import com.vcon.v1.apis.repository.UserRepository;
import com.vcon.v1.apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional // Added for password hashing before saving
    public User createUser(User user) {
        // Important: Hash the password before saving
        String rawPassword = user.getPasswordHash(); // Assuming getPasswordHash() holds the raw password
        String hashedPassword = passwordEncoder.encode(rawPassword);
        user.setPasswordHash(hashedPassword); // Set the hashed password
        return userRepository.save(user);
    }

    @Override
    @Transactional // Added for password hashing before updating
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setRole(user.getRole());
            // Check if a new password was provided and hash it
            if (user.getPasswordHash() != null && !user.getPasswordHash().isEmpty()) {
                updatedUser.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
            }
            // updatedUser.setPasswordHash(user.getPasswordHash()); // DO NOT SAVE PLAIN TEXT PASSWORD
            return userRepository.save(updatedUser);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}