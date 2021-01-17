package com.scanner.demo.mainApp.letterSingle.action.model;

public class UserChoise {
    private String userId;
    private String userFullName;

    public UserChoise() {
    }

    public UserChoise(String userId, String userFullName) {
        this.userId = userId;
        this.userFullName = userFullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
