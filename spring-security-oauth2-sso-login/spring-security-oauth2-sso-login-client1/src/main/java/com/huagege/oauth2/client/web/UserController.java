package com.huagege.oauth2.client.web;

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
    public Authentication user(Authentication user){
        return user;
    }
}
