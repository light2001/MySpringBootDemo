package com.myspring.cli.web;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

//默认控制器
@RestController
@Api(value="Home测试",tags="Home测试")
@RequestMapping(value="/home")
public class HomeController {
    @ApiOperation(value = "默认返回路由")
    @RequestMapping(value="Index", method = RequestMethod.POST)
    public String Index(){
        return "你好，世界22";
    }

    /*测试Baidu重定向*/
    @ApiOperation(value = "重定向到百度")
    @RequestMapping(value="Baidu", method = RequestMethod.GET)
    public ModelAndView Index1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:http://www.baidu.com");
        return mv;
    }

//    测试local路由
    @ApiOperation(value = "重定向到当前")
    @RequestMapping(value="local", method = RequestMethod.POST)
    public ModelAndView local(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/test1");
        return mv;
    }

//    测试返回值
    @ApiOperation(value = "重定向测试")
    @RequestMapping(value="test1", method = RequestMethod.POST)
    public String test1(){
        return "你好，张三丰1";
    }

    //    测试返回值
    @ApiOperation(value = "测试List入参")
    @PostMapping(value="/TestUser")
    public UserInfo UserInfo(@RequestBody UserInfo input){
        String temp= StringUtils.join(input.getUrlList(), ',');

        ArrayList list=new ArrayList();
        list.add("1");
        list.add("2");
        list.add(temp);
        UserInfo info=UserInfo.builder().Sex("男").Name("张三").UrlList(list).build();

        return info;
    }


}
