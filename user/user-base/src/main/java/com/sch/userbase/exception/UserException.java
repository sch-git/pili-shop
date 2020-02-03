package com.sch.userbase.exception;

import com.sch.commonbasic.enums.CommonEnum;

/**
 * @Description: 用户异常
 * @Author: chenghao.su
 * @Date: 2020/2/3 20:59
 */
public class UserException extends RuntimeException {
    public UserException(CommonEnum message) {
        super(message.toString());
    }

    public UserException(String message) {
        super(message);
    }
}
