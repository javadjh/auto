package com.scanner.demo.mainApp.kartable.upsertLetter.model;

public class sender {
    private String role;
    private String userId;

    public sender() {
    }

    public sender(String role, String userId) {
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
