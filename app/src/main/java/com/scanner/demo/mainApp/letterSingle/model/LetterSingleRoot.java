package com.scanner.demo.mainApp.letterSingle.model;

public class LetterSingleRoot {
    private data data;
    private boolean status;
    private String message;

    public com.scanner.demo.mainApp.letterSingle.model.data getData() {
        return data;
    }

    public void setData(com.scanner.demo.mainApp.letterSingle.model.data data) {
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
