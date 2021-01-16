package com.scanner.demo.mainApp.kartable.upsertLetter.model;

import java.util.List;

public class UpsertLetterRoot {
    private String id;
    private String parentId;
    private String actionType;
    private String title;
    private String content;
    private String urgency;
    private receiver receiver;
    private sender sender;
    private String contactId;
    private String confidentiality;
    private List<String> appendixes;
    private List<CopiesList> copies;
    private Boolean draft;

    public UpsertLetterRoot(String id, String parentId, String actionType, String title, String content, String urgency, com.scanner.demo.mainApp.kartable.upsertLetter.model.receiver receiver, com.scanner.demo.mainApp.kartable.upsertLetter.model.sender sender, String contactId, String confidentiality, List<String> appendixes, List<CopiesList> copies, Boolean draft) {
        this.id = id;
        this.parentId = parentId;
        this.actionType = actionType;
        this.title = title;
        this.content = content;
        this.urgency = urgency;
        this.receiver = receiver;
        this.sender = sender;
        this.contactId = contactId;
        this.confidentiality = confidentiality;
        this.appendixes = appendixes;
        this.copies = copies;
        this.draft = draft;
    }
}
