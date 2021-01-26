package com.huagege.oauth2.login.vo;

/**
 * @ClassName UserInfoVo
 * @Author zzrdark
 * @Date 2020-01-19 17:07
 * @Description TODO
 **/
public class UserInfoVo {
    private String roles;

    private String name;

    private String avatar;

    private String introduction;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
