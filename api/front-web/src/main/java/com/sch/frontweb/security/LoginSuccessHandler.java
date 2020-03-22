package com.sch.frontweb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.frontweb.entity.MyUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 * @Description: json登录成功处理器
 * @Author: chenghao.su
 * @Date: 2020/3/2 14:20
 */
@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    HttpSession session;

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
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, session.getId() + "jwt-security")
                .compact();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        MyUser user = (MyUser) authentication.getPrincipal();
        user.setToken(jwt);
        session.setAttribute(jwt, user.getId());
        String str = new ObjectMapper().writeValueAsString(new Result(ResultEnum.LOGIN_SUCCESS, user));
        out.write(str);
        out.flush();
        out.close();
    }

}
