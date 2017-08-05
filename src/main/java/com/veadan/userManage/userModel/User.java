package com.veadan.userManage.userModel;

/**
 * Created by Veadan on 2017/2/25.
 */

import java.io.Serializable;

/***
 * 用户名ID
 * 用户名称
 * 密码
 * 登录标记、组织ID、组织名称
 */
public class User  implements Serializable {

    private String userNo;
    private String userName;
    private String password;
    private String useFlag;
    private String organizationId;
    private String ckName;
    private String roleId;
    private String cardNo;
    private String image;
    private Object url;
    private String function;

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getCkName() {
        return ckName;
    }

    public void setCkName(String ckName) {
        this.ckName = ckName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
