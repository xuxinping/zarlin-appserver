package com.veadan.recManage.recModel;

import java.io.Serializable;

/**
 * Created by Veadan on 2017/6/19.
 */
public class PrintDetail implements Serializable{
    private String recId;
    private String itemId;
    private String itemName;
    private String itemModel;
    private String unit;
    private String suppId;
    private Long planPrice;
    private String requireDept;
    private String suppBatchNo;
    private String barcode;
    private String barCreateTime;


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSuppId() {
        return suppId;
    }

    public void setSuppId(String suppId) {
        this.suppId = suppId;
    }

    public Long getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(Long planPrice) {
        this.planPrice = planPrice;
    }

    public String getRequireDept() {
        return requireDept;
    }

    public void setRequireDept(String requireDept) {
        this.requireDept = requireDept;
    }

    public String getSuppBatchNo() {
        return suppBatchNo;
    }

    public void setSuppBatchNo(String suppBatchNo) {
        this.suppBatchNo = suppBatchNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarCreateTime() {
        return barCreateTime;
    }

    public void setBarCreateTime(String barCreateTime) {
        this.barCreateTime = barCreateTime;
    }
}
