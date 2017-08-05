package com.veadan.recManage.recModel;

import java.io.Serializable;

/**
 * Created by Veadan on 2017/8/4.
 */
public class RecSuppList implements Serializable {

    private String suppName;
    private Integer count;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
