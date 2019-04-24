package com.chinasofti.entity;

import java.util.List;

public class PageBean<T> {
    private Integer currentPage;  //当前页码

    private Integer pageSize;  //总页数

    private Integer recordCount; //总条数

    private Integer pageCount;   //每页条数

    private List<T> resultList;   // 数据
    public Integer getFirst() {
        return (currentPage-1)*pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage=currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount=recordCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount=pageCount;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList=resultList;
    }
}