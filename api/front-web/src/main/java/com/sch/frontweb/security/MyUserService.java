package com.sch.frontweb.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.frontweb.entity.MyUser;
import com.sch.userbase.VO.UserVO;
import com.sch.userbase.base.UserBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 自定义UserDetailsService
 * @Author: chenghao.su
 * @Date: 2020/3/2 13:10
 */
@Configuration
public class MyUserService implements UserDetailsService {
    /**
     * RPC调用Admin服务
     */
    @Reference(check = false, timeout = 60000)
    private UserBaseService userBaseService;

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        UserVO userVO = userBaseService.findUserByName(username);
        if (userVO == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        MyUser user = new MyUser();
        BeanUtils.copyProperties(userVO, user);
        user.setUsername(userVO.getName());
        // 赋值用户角色
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_LOGIN"));
        user.setAuthorities(authorities);
        return user;
    }
}
