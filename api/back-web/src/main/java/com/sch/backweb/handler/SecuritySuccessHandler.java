package com.sch.backweb.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.backweb.entity.User;
import com.sch.commonbasic.VO.Result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 * @Description: json登录成功处理器
 * @Author: chenghao.su
 * @Date: 2020/1/20 20:57
 */
@Configuration
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        StringBuffer stringBuffer = new StringBuffer();
        for (GrantedAuthority authority : authorities) {
            stringBuffer.append(authority.getAuthority()).append(",");
        }
        String jwt = Jwts.builder()
                .claim("authorities", stringBuffer)
                .setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "jwt-security")
                .compact();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        User user = (User) authentication.getPrincipal();
        user.setToken(jwt);
        String str = new ObjectMapper().writeValueAsString(Result.success(user));
        out.write(str);
        out.flush();
        out.close();
    }
}
