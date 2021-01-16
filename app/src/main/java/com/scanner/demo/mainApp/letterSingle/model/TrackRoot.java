package com.scanner.demo.mainApp.letterSingle.model;

import java.util.List;

public class TrackRoot {
    List<TrackDataLetter> data;
    private Boolean status;
    private String message;

    public List<TrackDataLetter> getData() {
        return data;
    }

    public void setData(List<TrackDataLetter> data) {
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
