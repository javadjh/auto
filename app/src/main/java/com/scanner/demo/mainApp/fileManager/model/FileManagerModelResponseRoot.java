package com.scanner.demo.mainApp.fileManager.model;

import java.util.List;

public class FileManagerModelResponseRoot {
    private UserFileList data;
    private boolean status;
    private String message;

    public UserFileList getData() {
        return data;
    }

    public void setData(UserFileList data) {
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
