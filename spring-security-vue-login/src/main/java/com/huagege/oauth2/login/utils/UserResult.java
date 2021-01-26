package com.huagege.oauth2.login.utils;

import org.springframework.security.core.Authentication;

/**
 * @ClassName UserResult
 * @Author zzrdark
 * @Date 2020-01-19 14:39
 * @Description TODO
 **/

public class UserResult {
    private Integer code;
    private Authentication authentication;
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
