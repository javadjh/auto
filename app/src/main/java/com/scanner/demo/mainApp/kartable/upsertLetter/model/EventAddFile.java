package com.scanner.demo.mainApp.kartable.upsertLetter.model;

public class EventAddFile {
    private String fileName;
    private String fileId;
    private boolean isAdded;

    public EventAddFile(String fileName, String fileId, boolean isAdded) {
        this.fileName = fileName;
        this.fileId = fileId;
        this.isAdded = isAdded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }
}
