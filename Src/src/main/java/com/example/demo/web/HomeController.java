package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @RequestMapping("Index")
    public String Index(){
        return "你好，世界22";
    }

    /*测试Baidu重定向*/
    @RequestMapping("Baidu")
    public ModelAndView Index1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:http://www.baidu.com");
        return mv;
    }


    @RequestMapping("local")
    public ModelAndView local(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/test1");
        return mv;
    }


    @RequestMapping("test1")
    public String test1(){
        return "你好，张三丰1";
    }

}
