package com.sch.feedback.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.feedback.dao.FeedBackDao;
import com.sch.feedback.entity.FeedBack;
import com.sch.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title: 反馈接口实现
 * @Author: chenghao.su
 * @Date: 2020/5/9 19:46
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackDao dao;

    /**
     * 用户反馈
     *
     * @param feedBack 反馈信息
     */
    @Override
    public void send(FeedBack feedBack) {
        dao.send(feedBack);
    }
}
