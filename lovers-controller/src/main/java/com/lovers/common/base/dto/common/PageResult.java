package com.lovers.common.base.dto.common;

import java.util.List;

/**
 * @Auther: wangzefeng
 * @Date: 2019-10-23 14:16
 * @Description:
 */
public class PageResult {
    //当前页码
    private int pageNum;
    //每页数量
    private int pageSize;
    //数据总条数
    private long totalSize;
    //页码总数
    private int totalPages;
    //数据
    private List<?> conent;
    public int getPageNum() {
        return pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public List<?> getConent() {
        return conent;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public void setConent(List<?> conent) {
        this.conent = conent;
    }
}
