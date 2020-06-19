package com.myspring.cli.service.impl;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.RegisterUser;
import com.myspring.cli.service.IUserService;
import io.swagger.annotations.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    public User GetLoginInfo(RegisterUser user){
      return null;
    };
}
