package com.huagege.login.springsecurity.userdetailsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName WebUserDetailsService
 * @Author zzrdark
 * @Date 2020-01-17 14:35
 * @Description TODO
 **/
@Component
public class WebUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 在这里实现用户密码校验，以及用户权限
         */
        String passwordEn = passwordEncoder.encode("123456");
        UserDetails userDetails = new User(username,passwordEn,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return userDetails;
    }
}
