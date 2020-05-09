package com.sch.feedback.dao;

import com.sch.feedback.entity.FeedBack;
import org.springframework.stereotype.Repository;

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
}