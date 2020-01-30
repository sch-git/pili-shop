package com.sch.commonbasic.enums;

/**
 * @Description: 统一返回信息
 * @Author: chenghao.su
 * @Date: 2020/1/21 18:17
 */
public enum ResultEnum {
    /**
     * 成功状态码
     */
    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),
    /**
     * 用户失败信息
     */
    LOGIN_FAILURE(100, "用户名或密码错误!"),
    NOT_LOGIN_FAILURE(500, "用户尚未登录，请前往登录！"),
    /**
     * 权限失败信息
     */
    NOT_PERMISSION_FAILURE(500, "权限不足，请联系管理员");

    /**
     * 变量
     */
    private Integer code;
    private String message;

    /**
     * 构造方法
     *
     * @param code    状态码
     * @param message 提示信息
     */
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
