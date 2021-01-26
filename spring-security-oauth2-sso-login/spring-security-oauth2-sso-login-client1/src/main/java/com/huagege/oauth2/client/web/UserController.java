package com.huagege.oauth2.client.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author zzrdark
 * @Date 2020-02-28 19:25
 * @Description TODO
 **/
@RestController
public class UserController {

    @RequestMapping("/user")
//    @PreAuthorize("hasRole('admin')")
    @PreAuthorize("hasRole('simpleuser')")
    public Authentication user(Authentication user){
        return user;
    }
    @RequestMapping("/adminUser")
    @PreAuthorize("hasRole('admin')")
    public Authentication adminUser(Authentication user){
        return user;
    }
}
