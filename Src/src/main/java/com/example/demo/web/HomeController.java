package com.example.demo.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//默认控制器
@RestController
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

}
