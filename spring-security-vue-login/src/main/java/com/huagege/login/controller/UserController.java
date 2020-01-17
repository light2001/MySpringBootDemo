package com.huagege.login.controller;

import com.huagege.login.utils.SimpleResponse;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Author zzrdark
 * @Date 2020-01-17 14:55
 * @Description TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @RequestMapping("/loginTo")
    public SimpleResponse login(){

        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}
