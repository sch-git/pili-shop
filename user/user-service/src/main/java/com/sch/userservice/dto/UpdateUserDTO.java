package com.sch.userservice.dto;

import com.sch.commonbasic.util.DateUtil;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import com.sch.userbase.AO.UpdateUserAO;
import lombok.Data;

/**
 * @Description: 修改用户信息
 * @Author: chenghao.su
 * @Date: 2020/3/23 16:46
 */
@Data
public class UpdateUserDTO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 修改时间
     */
    private String updateTime;

    public void setAO(UpdateUserAO ao) {
        this.id = ao.getId();
        this.avatar = ao.getAvatar().split(QiNiuCloudUtil.getDOMAIN())[1];
        this.nickName = ao.getNickName();
        this.sex = ao.getSex();
        this.updateTime = DateUtil.createTime();
    }
}
