package com.sch.commonbasic.enums;

/**
 * @Description: 管理员枚举提示信息
 * @Author: chenghao.su
 * @Date: 2020/1/20 19:48
 */
public enum UserEnum implements CommonEnum {
    /**
     * 异常信息提示
     */
    EXCEPTION_NOT_NAME("用户名不存在"),
    EXCEPTION_NOT_PARAM("请求信息错误");
    /**
     * 变量
     */
    private String msg;

    /**
     * 构造方法
     *
     * @param msg 异常提示信息
     */
    UserEnum(String msg) {
        this.msg = msg;
    }
}
