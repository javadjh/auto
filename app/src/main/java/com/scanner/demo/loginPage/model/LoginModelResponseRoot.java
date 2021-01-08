package com.scanner.demo.loginPage.model;

public class LoginModelResponseRoot {
    private data data;
    private boolean status;
    private String message;

    public com.scanner.demo.loginPage.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.loginPage.model.data data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
