package com.sch.frontweb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: 非法请求直接返回json 重定向->转发
 * @Author: chenghao.su
 * @Date: 2020/3/2 15:10
 */
@Configuration
public class AuthEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response
            , AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Result result = new Result(ResultEnum.NOT_LOGIN_FAILURE);
        if (authException instanceof InsufficientAuthenticationException) {
            result = new Result(ResultEnum.NOT_LOGIN_FAILURE);
        }
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}
