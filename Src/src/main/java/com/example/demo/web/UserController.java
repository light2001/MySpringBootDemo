package com.example.demo.web;

import java.util.List;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }



    /*测试Baidu重定向*/
    @RequestMapping("CEX")
    public ModelAndView CexIndex(){
        ModelAndView mv = new ModelAndView();
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJSUzMwNTMxIiwiZXhwIjoxNTU4NjY1NzkwfQ.yL1JYwJxtJvKKC4SeMjX0fkW1yKYlNxo3RS87N5HZFg";
        mv.setViewName("redirect:http://dev.cex.randstad-china.com/#/login?token="+token);
        return mv;
    }


}