package com.botwy.erp.entity;

import org.h2.result.Row;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;


public class DocWithTable {


    private Long id;

    private List<RowDoc> rowDocList;
    private BigDecimal totalSum;
    private Integer totalQuantity;
    boolean checkAvailableItem;

    public DocWithTable() {
    }

    public Long getId() {
        return id;
    }

    public List<RowDoc> getRowDocList() {
        return rowDocList;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public boolean isCheckAvailableItem() {
        return checkAvailableItem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRowDocList(List<RowDoc> rowDocList) {
        this.rowDocList = rowDocList;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setCheckAvailableItem(boolean checkAvailableItem) {
        this.checkAvailableItem = checkAvailableItem;
    }
}
