package com.sch.backweb.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Date: 2020/1/20 20:57
 */
@Configuration
public class SecurityFailureHandler implements AuthenticationFailureHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        LOGGER.info("SecurityFailureHandler");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String str = new ObjectMapper().writeValueAsString(new Result(ResultEnum.LOGIN_FAILURE));
        out.write(str);
        out.flush();
        out.close();
    }
}
