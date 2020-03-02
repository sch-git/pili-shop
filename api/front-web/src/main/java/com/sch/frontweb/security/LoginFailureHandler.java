package com.sch.frontweb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: json登录失败处理器
 * @Author: chenghao.su
 * @Date: 2020/3/2 14:21
 */
@Configuration
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String str = new ObjectMapper().writeValueAsString(new Result(ResultEnum.LOGIN_FAILURE));
        out.write(str);
        out.flush();
        out.close();
    }
}
