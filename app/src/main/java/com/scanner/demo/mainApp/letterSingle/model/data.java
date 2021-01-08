package com.scanner.demo.mainApp.letterSingle.model;

import java.util.List;

public class data {
    private String id;
    private String actionId;
    private parent parent;
    private String actionType;
    private String title;
    private String content;
    private String urgency;
    private String confidentiality;
    private String letterNumber;
    private String createdTime;
    private String createdDate;
    private String actionMadeTime;
    private String actionMadeDate;
    private sender sender;
    private actionMaker actionMaker;
    private receiver receiver;
    private List<Copies> copies;
    private String paraph;
    private List<Appendixes> appendixes;
    private contact contact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public com.scanner.demo.mainApp.letterSingle.model.parent getParent() {
        return parent;
    }

    public void setParent(com.scanner.demo.mainApp.letterSingle.model.parent parent) {
        this.parent = parent;
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

    public String getLetterNumber() {
        return letterNumber;
    }

    public void setLetterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public com.scanner.demo.mainApp.letterSingle.model.sender getSender() {
        return sender;
    }

    public void setSender(com.scanner.demo.mainApp.letterSingle.model.sender sender) {
        this.sender = sender;
    }

    public com.scanner.demo.mainApp.letterSingle.model.actionMaker getActionMaker() {
        return actionMaker;
    }

    public void setActionMaker(com.scanner.demo.mainApp.letterSingle.model.actionMaker actionMaker) {
        this.actionMaker = actionMaker;
    }

    public com.scanner.demo.mainApp.letterSingle.model.receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(com.scanner.demo.mainApp.letterSingle.model.receiver receiver) {
        this.receiver = receiver;
    }

    public List<Copies> getCopies() {
        return copies;
    }

    public void setCopies(List<Copies> copies) {
        this.copies = copies;
    }

    public String getParaph() {
        return paraph;
    }

    public void setParaph(String paraph) {
        this.paraph = paraph;
    }

    public List<Appendixes> getAppendixes() {
        return appendixes;
    }

    public void setAppendixes(List<Appendixes> appendixes) {
        this.appendixes = appendixes;
    }

    public com.scanner.demo.mainApp.letterSingle.model.contact getContact() {
        return contact;
    }

    public void setContact(com.scanner.demo.mainApp.letterSingle.model.contact contact) {
        this.contact = contact;
    }
}
