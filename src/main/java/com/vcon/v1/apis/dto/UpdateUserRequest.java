package com.vcon.v1.apis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequest {
    // We might allow updating only certain fields
    private String username;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password; // Consider how you want to handle password updates securely

    @Email(message = "Invalid email format")
    private String email;

    private String role;
}
