package com.sch.commonbasic.enums;

/**
 * @Description: 商品枚举提示信息
 * @Author: chenghao.su
 * @Date: 2020/2/14 17:40
 */
public enum CommodityEnum implements CommonEnum {
    /**
     * 异常信息提示
     */
    EXCEPTION_NULL("请求数据为空"),
    EXCEPTION_NULL_CREATEID("创建人CREATEID为空"),
    EXCEPTION_NULL_NAME("商品名称NAME为空"),
    EXCEPTION_NULL_CATEGORYNAME("分类名称NAME为空"),
    EXCEPTION_NULL_CATEGORYID("分类ID为空"),
    EXCEPTION_NULL_DESCRIBE("商品描述DESCRIBE为空"),
    EXCEPTION_NULL_PRICE("商品售价PRICE为空"),
    EXCEPTION_NULL_CREATENAME("创建人CREATENAME为空"),
    EXCEPTION_NULL_STATUS("状态STATUS为空"),
    EXCEPTION_NULL_URL("商品图片地址URL为空"),
    EXCEPTION_PARAMS_NULL("请求参数有误");
    /**
     * 变量
     */
    private String msg;

    /**
     * 构造方法
     *
     * @param msg 异常提示信息
     */
    CommodityEnum(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
