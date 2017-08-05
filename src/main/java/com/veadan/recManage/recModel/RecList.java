package com.veadan.recManage.recModel;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Veadan on 2017/6/18.
 */
public class RecList implements Serializable {

    private String recId;
    private String itemId;
    private String itemName;
    private Long recQty;
    private String invPhysic;
    private String recCreateTime;
    private String recMainId;
    private String suppBatchNo;

    public String getSuppBatchNo() {
        return suppBatchNo;
    }

    public void setSuppBatchNo(String suppBatchNo) {
        this.suppBatchNo = suppBatchNo;
    }

    public String getRecMainId() {
        return recMainId;
    }

    public void setRecMainId(String recMainId) {
        this.recMainId = recMainId;
    }

    private HashMap<String,Object> map;

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public String getInvPhysic() {
        return invPhysic;
    }

    public void setInvPhysic(String invPhysic) {
        this.invPhysic = invPhysic;
    }

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

    public Long getRecQty() {
        return recQty;
    }

    public void setRecQty(Long recQty) {
        this.recQty = recQty;
    }

    public String getRecCreateTime() {
        return recCreateTime;
    }

    public void setRecCreateTime(String recCreateTime) {
        this.recCreateTime = recCreateTime;
    }

}
