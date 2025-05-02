package com.vcon.v1.apis.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    public String getPasswordHash() {
        return passwordHash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(nullable = false)
    private String passwordHash; // Store the hashed password, not the plain text

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String role; // e.g., 'owner', 'manager', 'staff', 'customer'

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    // You might have a one-to-one relationship with Staff or Customer entities
    // depending on your design. For example:
    // @OneToOne(mappedBy = "user")
    // private Staff staff;

    // @OneToOne(mappedBy = "user")
    // private Customer customer;

    // Consider adding fields like 'isActive', 'lastLogin', etc.
}