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
    SUCCESS(200, ""),
    LOGIN_SUCCESS(200, "登陆成功"),
    LOGOUT_SUCCESS(200, "退出成功"),
    FAILURE(500, "失败"),
    UPLOAD_IMAGE(200, "上传图片成功"),
    ADD_SUCCESS(200, "添加数据成功"),
    DELETE_SUCCESS(200, "删除数据成功"),
    UPDATE_SUCCESS(200, "修改数据成功"),
    /**
     * 用户失败信息
     */
    LOGIN_FAILURE(100, "用户名或密码错误!"),
    LOGIN_NOT_NAME(100, "用户名不存在"),
    JWT_LOGIN_FAILURE(100, "JWT用户名或密码错误!"),
    NOT_LOGIN_FAILURE(500, "用户尚未登录，请前往登录！"),
    /**
     * 用户成功信息
     */
    UPDATE_USER_STATUS(200, "修改用户状态成功"),
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

}
