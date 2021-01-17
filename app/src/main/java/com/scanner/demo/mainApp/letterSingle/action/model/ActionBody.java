package com.scanner.demo.mainApp.letterSingle.action.model;

import java.util.List;

public class ActionBody {
    private String letterId;
    private String actionId;
    private String type;
    private String paraph;
    private List<String> recipients;
    private List<String> files;

    public ActionBody(String letterId, String actionId, String type, String paraph, List<String> recipients, List<String> files) {
        this.letterId = letterId;
        this.actionId = actionId;
        this.type = type;
        this.paraph = paraph;
        this.recipients = recipients;
        this.files = files;
    }
}
