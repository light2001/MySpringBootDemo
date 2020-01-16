package com.huagege.login.springsecurity.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import sun.security.util.SecurityConstants;

/**
 * @ClassName BrowserSecurityConfiguration
 * @Author zzrdark
 * @Date 2020-01-16 19:51
 * @Description TODO
 **/
@EnableWebSecurity
public class BrowserSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/statics/index.html#/login")
//                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .and()
                .authorizeRequests()
                    .antMatchers("/statics/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
