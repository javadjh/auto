package com.scanner.demo.mainApp.kartable.upsertLetter.model;

import java.util.List;

public class UsersResponseRoot {
    private List<UsersDataList> data;
    private Boolean status;
    private String message;

    public List<UsersDataList> getData() {
        return data;
    }

    public void setData(List<UsersDataList> data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
