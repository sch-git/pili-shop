package com.sch.adminbase.exception;

import com.sch.commonbasic.enums.CommonEnum;

/**
 * @Description: 管理员异常处理
 * @Author: chenghao.su
 * @Date: 2020/1/20 18:59
 */
public class AdminException extends RuntimeException {
    public AdminException(CommonEnum message) {
        super(message.toString());
    }

    public AdminException(String message) {
        super(message);
    }
}
