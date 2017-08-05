package com.veadan.userManage.userModel;

import java.io.Serializable;

/**
 * Created by Veadan on 2017/7/14.
 */
public class UserFunction implements Serializable {

    private String functionId;
    private String functionName;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
