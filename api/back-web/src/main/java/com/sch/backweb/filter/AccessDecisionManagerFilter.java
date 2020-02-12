package com.sch.backweb.filter;

import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Description: 判断是否有权访问
 * @Author: chenghao.su
 * @Date: 2020/1/25 12:52
 */
@Configuration
public class AccessDecisionManagerFilter implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        // collection：请求所需角色
        for (ConfigAttribute attribute : collection) {
            if ("ROLE_LOGIN".equals(attribute.getAttribute())) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException(ResultEnum.NOT_PERMISSION_FAILURE.getMessage());
                } else {
                    return;
                }
            }
            // authorities：用户所有角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(attribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException(ResultEnum.NOT_PERMISSION_FAILURE.getMessage());
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
