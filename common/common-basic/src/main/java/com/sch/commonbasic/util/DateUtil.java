package com.sch.commonbasic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 时间转换处理类
 * @Author: chenghao.su
 * @Date: 2020/2/5 17:58
 */
public class DateUtil {
    /**
     * 生成当前时间
     *
     * @return 数据库形式当前时间
     */
    public static String createTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 数据库时间转换为系统时间
     *
     * @param date 数据库时间
     * @return 字符串形式时间
     */
    public static String toString(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
    }

}
