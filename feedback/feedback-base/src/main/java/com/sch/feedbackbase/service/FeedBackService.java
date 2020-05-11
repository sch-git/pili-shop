package com.sch.feedbackbase.service;

import com.sch.feedbackbase.entity.FeedBack;

import java.util.List;

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

    /**
     * 查询反馈信息
     *
     * @param sid 发送者id
     * @return 反馈列表
     */
    List<FeedBack> findAll(long sid);
}
