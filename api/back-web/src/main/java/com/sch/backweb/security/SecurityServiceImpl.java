package com.sch.backweb.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.adminbase.VO.AdminVO;
import com.sch.adminbase.base.AdminBaseService;
import com.sch.backweb.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description: 自定义用户认证
 * @Author: chenghao.su
 * @Date: 2020/1/21 20:01
 */
@Service
public class SecurityServiceImpl implements UserDetailsService {

    @Reference(check = false, timeout = 60000)
    private AdminBaseService adminBaseService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AdminVO adminVO = adminBaseService.find(name);
        if (adminVO == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        User user = new User();
        BeanUtils.copyProperties(adminVO, user);
        return user;
    }
}
