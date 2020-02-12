package com.sch.backweb.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sch.backweb.entity.User;
import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 * @Description: JWT登录过滤器-未启用
 * @Author: chenghao.su
 * @Date: 2020/2/12 09:56
 */
public class JwtAuthFilter extends AbstractAuthenticationProcessingFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthFilter.class);

    public JwtAuthFilter(String defaultFilterProcessesUrl, AuthenticationManager auth) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(auth);
        LOGGER.info("JwtAuthFilter-JwtAuthFilter");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        LOGGER.info("JwtAuthFilter-attemptAuthentication");
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        LOGGER.info("JwtAuthFilter-successfulAuthentication");
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

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse resp, AuthenticationException failed) throws IOException, ServletException {
        LOGGER.info("JwtAuthFilter-unsuccessfulAuthentication");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String str = new ObjectMapper().writeValueAsString(new Result(ResultEnum.LOGIN_FAILURE));
        out.write(str);
        out.flush();
        out.close();
    }
}
