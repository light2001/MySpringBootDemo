package com.huagege.oauth2.demo2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                // <X> 使用内存中的 InMemoryUserDetailsManager
                        inMemoryAuthentication()
                // <Y> 不使用 PasswordEncoder 密码编码器
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // <Z> 配置 admin 用户
                .withUser("admin").password("admin").roles("ADMIN")
                // <Z> 配置 normal 用户
                .and().withUser("normal").password("normal").roles("NORMAL");
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .dataSource()

    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/test/echo").permitAll() // 所有用户可访问
                .antMatchers("/test/admin").hasRole("ADMIN") // 需要 ADMIN 角色
                .antMatchers("/test/normal").access("hasRole('ROLE_NORMAL')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/login")
                // 所有用户可访问
                .permitAll()
                .and()
                .logout()
                //.logoutUrl("/logout") // 退出 URL 地址
                .permitAll();
    }
}