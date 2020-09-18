package com.bbu.util;

public enum ResultEnum {

    SUCCESS(200,"OK"),
    NOT_FOUND(1004,"密码有误"),
    FAILED(1005,"操作失败"),
    USER_IP_LIMIT(1006,"网络地址不正确"),
    USER_LOCK(1007,"账号被锁定"),
    USER_EXPIRETIME(1008,"账号逾期"),
    USER_NOT_FOUND(1009,"账号逾期"),
    USERNAME_NOT_FOUND(1010,"用户名错误"),
    UNKNOWN_EXCEPTION(1001,"未定义错误"),
    FILE_NOT_FOUND(1011,"未找到数据"),
    PARAM_ERROR(2001,"数据获取失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
