package com.sch.userservice.dto;

import com.sch.commonbasic.util.DateUtil;
import com.sch.userbase.AO.UpdateUserStatusAO;
import lombok.Data;

/**
 * @Description: 修改用户状态条件
 * @Author: chenghao.su
 * @Date: 2020/2/5 16:39
 */
@Data
public class UpdateUserStatusDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 修改时间
     */
    private String updateTime;

    public void setAO(UpdateUserStatusAO ao) {
        this.id = ao.getId();
        this.status = ao.getStatus();
        this.updateTime = DateUtil.createTime();
    }
}
