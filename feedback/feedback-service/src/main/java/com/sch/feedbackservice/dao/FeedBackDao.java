package com.sch.feedbackservice.dao;

import com.sch.feedbackbase.entity.FeedBack;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sch
 */
@Repository
public interface FeedBackDao {
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