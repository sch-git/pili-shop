package com.sch.commoditybase.exception;

import com.sch.commonbasic.enums.CommonEnum;

/**
 * @Description: 商品异常
 * @Author: chenghao.su
 * @Date: 2020/2/14 16:14
 */
public class CommodityException extends RuntimeException {

    public CommodityException(CommonEnum commonEnum) {
        super(commonEnum.getMsg());
    }

    public CommodityException(String message) {
        super(message);
    }
}
