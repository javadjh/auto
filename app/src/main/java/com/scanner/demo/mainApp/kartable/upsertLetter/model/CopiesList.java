package com.scanner.demo.mainApp.kartable.upsertLetter.model;

public class CopiesList {
    private String userId;
    private String type;
    private String content;
    private String fullName;

    public CopiesList(String userId, String type, String content, String fullName) {
        this.userId = userId;
        this.type = type;
        this.content = content;
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
