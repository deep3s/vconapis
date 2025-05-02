package com.vcon.v1.apis.service;

import com.vcon.v1.apis.dto.ApiResponse;
import com.vcon.v1.apis.dto.LoginRequest;
import com.vcon.v1.apis.dto.LoginResponse;
import com.vcon.v1.apis.entity.User;
import com.vcon.v1.apis.repository.UserRepository;
import com.vcon.v1.apis.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ResponseEntity<ApiResponse<LoginResponse>> authenticateUser(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
                // Authentication successful, generate JWT tokens
                String accessToken = jwtService.generateAccessToken(user);
                String refreshToken = jwtService.generateRefreshToken(user);
                long expirationTime = jwtService.getExpirationTime(); // Get access token expiration

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setAccessToken(accessToken);
                loginResponse.setRefreshToken(refreshToken);
                loginResponse.setTokenType("Bearer");
                loginResponse.setExpiresIn(expirationTime / 1000); // Convert to seconds

                return ResponseEntity.ok(ApiResponse.success("Authentication successful", loginResponse));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Invalid username or password"));
    }

    // Method to handle refresh token requests
    public ResponseEntity<ApiResponse<LoginResponse>> refreshToken(String refreshToken) {
        String username = jwtService.extractUsername(refreshToken);

        if (username != null) {
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // In a real scenario, you might want to check if the refresh token is still valid
                // (e.g., by storing refresh tokens in a database and checking its expiration).
                // For simplicity, we'll just generate a new access token if the username is valid.

                String newAccessToken = jwtService.generateAccessToken(user);
                long expirationTime = jwtService.getExpirationTime();

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setAccessToken(newAccessToken);
                loginResponse.setRefreshToken(refreshToken); // You might issue a new refresh token as well
                loginResponse.setTokenType("Bearer");
                loginResponse.setExpiresIn(expirationTime / 1000);

                return ResponseEntity.ok(ApiResponse.success("Token refreshed successfully", loginResponse));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Invalid refresh token"));
    }
}