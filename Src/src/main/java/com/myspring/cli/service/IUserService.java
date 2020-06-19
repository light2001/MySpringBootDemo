package com.myspring.cli.service;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.RegisterUser;

public interface IUserService {
    public User GetLoginInfo(RegisterUser user);
}
