package com.huagege.oauth2.login.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExampleController
 * @Author zzrdark
 * @Date 2020-01-21 10:46
 * @Description TODO
 **/
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @RequestMapping("/hello")
    public String hello() {
        return "world";
    }

}