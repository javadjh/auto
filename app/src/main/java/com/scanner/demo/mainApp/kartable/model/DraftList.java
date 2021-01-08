package com.scanner.demo.mainApp.kartable.model;

import com.scanner.demo.mainApp.homePage.model.copies;
import com.scanner.demo.mainApp.letterSingle.model.receiver;
import com.scanner.demo.mainApp.letterSingle.model.sender;

import java.util.List;

public class DraftList {
    private String id;
    private String parentId;
    private String title;
    private String createdDate;
    private String createdTime;
    private String content;
    private String urgency;
    private String confidentiality;
    private com.scanner.demo.mainApp.letterSingle.model.sender sender;
    private com.scanner.demo.mainApp.letterSingle.model.receiver receiver;
    private List<com.scanner.demo.mainApp.homePage.model.copies> copies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
    }

    public com.scanner.demo.mainApp.letterSingle.model.sender getSender() {
        return sender;
    }

    public void setSender(com.scanner.demo.mainApp.letterSingle.model.sender sender) {
        this.sender = sender;
    }

    public com.scanner.demo.mainApp.letterSingle.model.receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(com.scanner.demo.mainApp.letterSingle.model.receiver receiver) {
        this.receiver = receiver;
    }

    public List<com.scanner.demo.mainApp.homePage.model.copies> getCopies() {
        return copies;
    }

    public void setCopies(List<com.scanner.demo.mainApp.homePage.model.copies> copies) {
        this.copies = copies;
    }
}
