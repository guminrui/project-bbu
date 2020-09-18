package com.bbu.util;

import java.util.List;

public class ResultPage<T> {
    private  long page;
    private List<T> rows;

    @Override
    public String toString() {
        return "ResultPage{" +
                "page=" + page +
                ", rows=" + rows +
                '}';
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
