package com.huagege.oauth2.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("112233"));
    }*/

}