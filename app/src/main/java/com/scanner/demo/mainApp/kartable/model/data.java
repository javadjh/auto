package com.scanner.demo.mainApp.kartable.model;

import java.util.List;

public class data {
    private int pageNumber;
    private int pageSize;
    private int totalResults;
    private List<DraftList> list;

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

    public List<DraftList> getList() {
        return list;
    }

    public void setList(List<DraftList> list) {
        this.list = list;
    }
}
