package pri.cxq.bean;

import java.util.List;

public class PageBean<T> {
    private Integer currentPage;//当前页面
    private Integer pageSize;//每页行数
    private Integer beforePage;//上一页
    private Integer afterPage;//下一页
    private Integer totalRows;//总行数
    private Integer totalPages;//总页数
    private List<T> lists;//展示的元素集合

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalRows, List<T> lists) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.lists = lists;
        this.totalPages = this.totalRows % this.pageSize == 0 ? totalRows / pageSize : totalRows / pageSize + 1;
        this.beforePage = this.currentPage - 1 <= 0 ? 1 : this.currentPage - 1;
        this.afterPage = this.currentPage + 1 >= this.totalPages ? this.totalPages : this.currentPage + 1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeforePage() {
        return beforePage;
    }

    public void setBeforePage(Integer beforePage) {
        this.beforePage = beforePage;
    }

    public Integer getAfterPage() {
        return afterPage;
    }

    public void setAfterPage(Integer afterPage) {
        this.afterPage = afterPage;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
