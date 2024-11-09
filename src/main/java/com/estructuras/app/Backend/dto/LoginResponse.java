package com.estructuras.app.Backend.dto;

public class LoginResponse {
    private boolean authenticated;
    private Long userId;

    public LoginResponse(boolean authenticated, Long userId) {
        this.authenticated = authenticated;
        this.userId = userId;
    }

    // Getters and Setters
    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
