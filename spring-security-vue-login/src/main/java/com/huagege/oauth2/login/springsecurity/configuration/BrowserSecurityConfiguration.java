package com.huagege.oauth2.login.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @ClassName BrowserSecurityConfiguration
 * @Author zzrdark
 * @Date 2020-01-16 19:51
 * @Description TODO
 **/
@EnableWebSecurity
@Configuration
public class BrowserSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/statics/index.html#/login")
                .loginProcessingUrl("/user/login")
                .successHandler(authenticationSuccessHandler)
                .and()
                .authorizeRequests()
                    .antMatchers("/statics/**",
                            "/user/login",
                            "/user/loginTo").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RedirectStrategy redirectStrategy(){
        return new DefaultRedirectStrategy();
    }


}
