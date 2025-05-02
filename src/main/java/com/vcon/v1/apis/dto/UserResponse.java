package com.vcon.v1.apis.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public String getPasswordHash() {
        return null;
    }

    public void setPasswordHash(String email) {
        this.email = email;
    }
    // You might choose to include or exclude other fields based on your API requirements
}