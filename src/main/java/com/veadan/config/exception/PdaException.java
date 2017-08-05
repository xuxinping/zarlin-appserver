package com.veadan.config.exception;

import com.veadan.config.resultFormat.EnumCode;

/**
 * Created by Veadan on 2017/5/1.
 */
public class PdaException extends RuntimeException {

    private Integer val;
    public PdaException(EnumCode enumCode){
        super(enumCode.msg());
        this.val= enumCode.val();
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;

    }

}
