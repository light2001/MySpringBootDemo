package com.example.demo.web;

import java.util.List;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Api(value="用户模块")
@RestController
@RequestMapping(value="/User")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据用户id查询用户")
    @RequestMapping(value="/getUsers", method = RequestMethod.POST)
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping(value="/getUser", method = RequestMethod.POST)
    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update", method = RequestMethod.POST)
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }



    /*测试Baidu重定向*/
    @RequestMapping(value="CEX", method = RequestMethod.POST)
    public ModelAndView CexIndex(){
        ModelAndView mv = new ModelAndView();
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJSUzMwNTMxIiwiZXhwIjoxNTU4NjY1NzkwfQ.yL1JYwJxtJvKKC4SeMjX0fkW1yKYlNxo3RS87N5HZFg";
        mv.setViewName("redirect:http://dev.cex.randstad-china.com/#/login?token="+token);
        return mv;
    }


}