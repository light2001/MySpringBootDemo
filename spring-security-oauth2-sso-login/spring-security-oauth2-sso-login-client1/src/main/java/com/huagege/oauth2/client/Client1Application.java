package com.huagege.oauth2.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @ClassName Client1Application
 * @Author zzrdark
 * @Date 2020-02-28 19:21
 * @Description TODO
 **/
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Client1Application {
    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class,args);
    }
}
