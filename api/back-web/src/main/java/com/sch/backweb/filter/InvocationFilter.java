package com.sch.backweb.filter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sch.adminbase.VO.RoleVO;
import com.sch.adminbase.base.RoleBaseService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.List;

/**
 * @Description: 分析请求地址所需角色
 * @Author: chenghao.su
 * @Date: 2020/1/25 11:43
 */
@Configuration
public class InvocationFilter implements FilterInvocationSecurityMetadataSource {
    @Reference(check = false, timeout = 60000)
    private RoleBaseService roleBaseService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<RoleVO> roleVOS = roleBaseService.findRolesByUrl(requestUrl);
        if (roleVOS != null) {
            String[] roleStr = new String[roleVOS.size()];
            for (int i = 0; i < roleVOS.size(); i++) {
                roleStr[i] = roleVOS.get(i).getCode();
            }
            return SecurityConfig.createList(roleStr);
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
