package com.sch.feedbackservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sch.commonbasic.util.DateUtil;
import com.sch.feedbackbase.entity.FeedBack;
import com.sch.feedbackbase.service.FeedBackService;
import com.sch.feedbackservice.dao.FeedBackDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        feedBack.setRid(0L);
        feedBack.setCreateTime(DateUtil.createTime());
        dao.send(feedBack);
    }

    /**
     * 查询反馈信息
     *
     * @param sid 发送者id
     * @return 反馈列表
     */
    @Override
    public List<FeedBack> findAll(long sid) {
        return dao.findAll(sid);
    }
}
