package com.scanner.demo.mainApp.kartable.model;

public class DraftResponseRoot {
    private data data;
    private boolean status;
    private String message;

    public com.scanner.demo.mainApp.kartable.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.kartable.model.data data) {
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