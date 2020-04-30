package com.myspring.cli.web;

import java.util.List;

import com.myspring.cli.model.User;
import com.myspring.cli.repo.UserRepository;
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
    private UserRepository userService;

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users=userService.findAll();
        return users;
    }
    @ApiOperation(value = "根据ID获取用户信息")
    @RequestMapping(value="/getUser", method = RequestMethod.POST)
    public User getUser(Long id) {
        User user=userService.getOne(id);
        return user;
    }
    @ApiOperation(value = "新增")
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void save(User user) {
        userService.save(user);
    }
    @ApiOperation(value = "更新")
    @RequestMapping(value="update", method = RequestMethod.POST)
    public void update(User user) {
        userService.save(user);
    }
    @ApiOperation(value = "删除")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }


    @ApiOperation(value = "重定向到cex的页面")
    @RequestMapping(value="CEX", method = RequestMethod.POST)
    public ModelAndView CexIndex(){
        ModelAndView mv = new ModelAndView();
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJSUzMwNTMxIiwiZXhwIjoxNTU4NjY1NzkwfQ.yL1JYwJxtJvKKC4SeMjX0fkW1yKYlNxo3RS87N5HZFg";
        mv.setViewName("redirect:http://dev.cex.randstad-china.com/#/login?token="+token);
        return mv;
    }


}