package com.vcon.v1.apis.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private ApiError error;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, null, data, null);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null, null);
    }

    public static <T> ApiResponse<T> error(String message, ApiError error) {
        return new ApiResponse<>(false, message, null, error);
    }

    // Private constructor
    private ApiResponse(boolean success, String message, T data, ApiError error) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.error = error;
    }
}
