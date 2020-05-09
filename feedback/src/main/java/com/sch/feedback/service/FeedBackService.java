package com.sch.feedback.service;

import com.sch.feedback.entity.FeedBack;

/**
 * @Title: 反馈接口
 * @Author: chenghao.su
 * @Date: 2020/5/9 19:45
 */
public interface FeedBackService {
    /**
     * 用户反馈
     *
     * @param feedBack 反馈信息
     */
    void send(FeedBack feedBack);
}
