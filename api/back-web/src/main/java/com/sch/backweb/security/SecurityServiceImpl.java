package com.sch.backweb.security;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.adminbase.VO.AdminVO;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.AdminBaseService;
import com.sch.adminbase.base.RoleBaseService;
import com.sch.backweb.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 自定义用户认证
 * @Author: chenghao.su
 * @Date: 2020/1/21 20:01
 */
@Service
public class SecurityServiceImpl implements UserDetailsService {

    /**
     * RPC调用Admin服务
     */
    @Reference(check = false, timeout = 60000)
    private AdminBaseService adminBaseService;
    /**
     * RPC调用Role服务
     */
    @Reference(check = false, timeout = 60000)
    private RoleBaseService roleBaseService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AdminVO adminVO = adminBaseService.findByName(name);
        if (adminVO == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        User user = new User();
        BeanUtils.copyProperties(adminVO, user);
        // 赋值用户角色
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<RoleVO> roleVOS = roleBaseService.findRolesByAdminId(user.getId());
        for (RoleVO roleVO : roleVOS) {
            authorities.add(new SimpleGrantedAuthority(roleVO.getCode()));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        user.setAuthorities(authorities);
        return user;
    }
}
