package com.scanner.demo.mainApp.homePage.model;

import java.util.List;

public class ListLetter {
    private String id;
    private int index;
    private String parentId;
    private String actionId;
    private String actionType;
    private String title;
    private String letterNumber;
    private String createdAt;
    private String actionMadeTime;
    private String actionMadeDate;
    private String content;
    private String urgency;
    private String confidentiality;
    private boolean observationStatus;
    private sender sender;
    private actionMaker actionMaker;
    private receiver receiver;
    private java.util.List<copies> copies;
    private java.util.List<appendixes> appendixes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLetterNumber() {
        return letterNumber;
    }

    public void setLetterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getActionMadeTime() {
        return actionMadeTime;
    }

    public void setActionMadeTime(String actionMadeTime) {
        this.actionMadeTime = actionMadeTime;
    }

    public String getActionMadeDate() {
        return actionMadeDate;
    }

    public void setActionMadeDate(String actionMadeDate) {
        this.actionMadeDate = actionMadeDate;
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

    public boolean isObservationStatus() {
        return observationStatus;
    }

    public void setObservationStatus(boolean observationStatus) {
        this.observationStatus = observationStatus;
    }

    public com.scanner.demo.mainApp.homePage.model.sender getSender() {
        return sender;
    }

    public void setSender(com.scanner.demo.mainApp.homePage.model.sender sender) {
        this.sender = sender;
    }

    public com.scanner.demo.mainApp.homePage.model.actionMaker getActionMaker() {
        return actionMaker;
    }

    public void setActionMaker(com.scanner.demo.mainApp.homePage.model.actionMaker actionMaker) {
        this.actionMaker = actionMaker;
    }

    public com.scanner.demo.mainApp.homePage.model.receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(com.scanner.demo.mainApp.homePage.model.receiver receiver) {
        this.receiver = receiver;
    }

    public java.util.List<com.scanner.demo.mainApp.homePage.model.copies> getCopies() {
        return copies;
    }

    public void setCopies(java.util.List<com.scanner.demo.mainApp.homePage.model.copies> copies) {
        this.copies = copies;
    }

    public java.util.List<com.scanner.demo.mainApp.homePage.model.appendixes> getAppendixes() {
        return appendixes;
    }

    public void setAppendixes(java.util.List<com.scanner.demo.mainApp.homePage.model.appendixes> appendixes) {
        this.appendixes = appendixes;
    }
}
