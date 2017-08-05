package com.veadan.config.resultFormat;

/**
 *
 * 配置API返回JSON格式{"code":"200","message":"登录成功！","data":null}
 * Created by 徐新平 on 2017/4/28.
 */
public class JsonResult {
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;
    private Integer code;
    private String message;
    private Object data;

    public JsonResult() {
        this.setCode(EnumCode.SUCCESS);
        this.setMessage("成功！");

    }

    public JsonResult(EnumCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public JsonResult(EnumCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }


    public JsonResult(Integer count, EnumCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
        this.setCount(count);

    }

    public JsonResult(EnumCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(EnumCode code) {
        this.code = code.val();
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
