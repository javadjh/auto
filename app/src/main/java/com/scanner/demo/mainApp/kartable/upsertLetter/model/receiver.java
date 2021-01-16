package com.scanner.demo.mainApp.kartable.upsertLetter.model;

public class receiver {
    private String role;
    private String userId;

    public receiver() {
    }

    public receiver(String role, String userId) {
        this.role = role;
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
