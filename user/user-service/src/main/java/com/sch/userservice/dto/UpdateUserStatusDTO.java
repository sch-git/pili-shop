package com.sch.userservice.dto;

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
    private Integer status;

    /**
     * 修改时间
     */
    private String updateTime;

    public void setAO(UpdateUserStatusAO ao) {
        this.id = ao.getId();
        if (ao.getStatus()) {
            this.status = 1;
        } else {
            this.status = 0;
        }
    }
}
