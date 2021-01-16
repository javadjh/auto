package com.scanner.demo.mainApp.letterSingle.model;

import java.util.List;

public class TrackDataLetter {
    private String actionId;
    private String actionMadeTime;
    private String actionMadeDate;
    private String paraph;
    private String actionType;
    private ActionMaker actionMaker;
    private List<Receivers> receivers;

    public String getActionMadeDate() {
        return actionMadeDate;
    }

    public void setActionMadeDate(String actionMadeDate) {
        this.actionMadeDate = actionMadeDate;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionMadeTime() {
        return actionMadeTime;
    }

    public void setActionMadeTime(String actionMadeTime) {
        this.actionMadeTime = actionMadeTime;
    }

    public String getParaph() {
        return paraph;
    }

    public void setParaph(String paraph) {
        this.paraph = paraph;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public ActionMaker getActionMaker() {
        return actionMaker;
    }

    public void setActionMaker(ActionMaker actionMaker) {
        this.actionMaker = actionMaker;
    }

    public List<Receivers> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Receivers> receivers) {
        this.receivers = receivers;
    }
}
