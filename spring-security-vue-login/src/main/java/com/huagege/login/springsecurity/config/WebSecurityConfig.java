package com.huagege.login.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassName WebSecurityConfig
 * @Author zzrdark
 * @Date 2020-01-16 19:37
 * @Description TODO
 **/

public class WebSecurityConfig {

    //@Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){

            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                UserDetails userDetails = User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("admin")
                        .build();
                return userDetails;
            }
        };
    }


}
