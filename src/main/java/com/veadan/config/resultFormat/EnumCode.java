package com.veadan.config.resultFormat;

/**
 * Created by Veadan on 2017/4/28.
 */
public enum EnumCode {

        /** 成功 */
        SUCCESS(200, "成功"),

        /** 没有登录 */
        NOT_LOGIN(201, "没有登录"),

        FAILED(203,"查询失败"),

        /** 发生异常 */
        EXCEPTION(401, "发生异常"),

        /** 系统错误 */
        SYS_ERROR(402, "系统错误"),

        /** 参数错误 */
        PARAMS_ERROR(204, "参数错误 "),

        /** 不支持或已经废弃 */
        NOT_SUPPORTED(410, "不支持或已经废弃"),

        /** AuthCode错误 */
        INVALID_AUTHCODE(444, "无效的AuthCode"),

        /** 太频繁的调用 */
        TOO_FREQUENT(445, "太频繁的调用"),

        /** 未知的错误 */
        UNKNOWN_ERROR(499, "未知错误");

        private Integer val;
        private String msg;

        private EnumCode(Integer value, String msg){
            this.val = value;
            this.msg = msg;
        }

        public Integer val() {
            return val;
        }

        public String msg() {
            return msg;
        }




}
