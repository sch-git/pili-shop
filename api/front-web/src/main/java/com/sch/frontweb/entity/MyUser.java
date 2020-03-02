package com.sch.frontweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Description: SECURITY用户类
 * @Author: chenghao.su
 * @Date: 2020/3/2 13:06
 */
@Data
public class MyUser implements UserDetails {
    /**
     * id
     */
    @JsonIgnore
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;

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
     * 积分
     */
    private Integer points;
    /**
     * 状态
     */
    private Boolean status;
    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * JWT token
     */
    private String token;
    /**
     * 用户权限集合
     */
    private List<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
