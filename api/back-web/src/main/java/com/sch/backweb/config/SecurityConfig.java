package com.sch.backweb.config;

import com.sch.backweb.filter.JsonAuthenticationFilter;
import com.sch.backweb.handler.SecurityAuthEntryPointHandler;
import com.sch.backweb.handler.SecurityFailureHandler;
import com.sch.backweb.handler.SecuritySuccessHandler;
import com.sch.backweb.security.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: Security配置
 * @Author: chenghao.su
 * @Date: 2020/1/20 19:26
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityServiceImpl securityService;
    @Autowired
    private SecuritySuccessHandler successHandler;
    @Autowired
    private SecurityFailureHandler failureHandler;
    @Autowired
    private SecurityAuthEntryPointHandler authEntryPointHandler;

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义json登录过滤器
     *
     * @return
     * @throws Exception
     */
    @Bean
    public JsonAuthenticationFilter jsonAuthenticationFilter() throws Exception {
        JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
        filter.setAuthenticationFailureHandler(failureHandler);
        filter.setAuthenticationSuccessHandler(successHandler);
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /**
     * 认证管理器
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义UserDetailsService
        auth.userDetailsService(securityService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPointHandler);
        http.addFilterAt(jsonAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
    }
}

