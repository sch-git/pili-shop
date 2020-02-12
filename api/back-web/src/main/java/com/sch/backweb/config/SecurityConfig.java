package com.sch.backweb.config;

import com.sch.backweb.filter.AccessDecisionManagerFilter;
import com.sch.backweb.filter.InvocationFilter;
import com.sch.backweb.filter.JsonAuthenticationFilter;
import com.sch.backweb.filter.JwtFilter;
import com.sch.backweb.handler.SecurityAccessDeniedHandler;
import com.sch.backweb.handler.SecurityAuthEntryPointHandler;
import com.sch.backweb.handler.SecurityFailureHandler;
import com.sch.backweb.handler.SecuritySuccessHandler;
import com.sch.backweb.security.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
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
    /**
     * 登录成功处理器
     */
    @Autowired
    private SecuritySuccessHandler successHandler;
    /**
     * 登录失败处理器
     */
    @Autowired
    private SecurityFailureHandler failureHandler;
    /**
     * 非法请求处理器
     */
    @Autowired
    private SecurityAuthEntryPointHandler authEntryPointHandler;
    /**
     * 请求路径需要角色
     */
    @Autowired
    private InvocationFilter invocationFilter;
    /**
     * 请求需要角色与用户角色判断
     */
    @Autowired
    private AccessDecisionManagerFilter managerFilter;
    /**
     * 自定义权限不足处理
     */
    @Autowired
    private SecurityAccessDeniedHandler accessDeniedHandler;
    /**
     * 自定义JWT-token过滤器
     */
    @Autowired
    private JwtFilter jwtFilter;

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
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(managerFilter);
                        o.setSecurityMetadataSource(invocationFilter);
                        return o;
                    }
                })
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPointHandler)
                .accessDeniedHandler(accessDeniedHandler);
        http.addFilterAt(jsonAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.addFilterAt(new JwtAuthFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/admin/avatar");
    }
}

