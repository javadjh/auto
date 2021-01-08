package com.scanner.demo.mainApp.fileManager.model;

import java.util.List;

public class UserFileList {
    private int pageNumber;
    private int pageSize;
    private int totalResults;
    private List<FileList> list;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<FileList> getList() {
        return list;
    }

    public void setList(List<FileList> list) {
        this.list = list;
    }
}
