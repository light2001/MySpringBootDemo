package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @RequestMapping(value="Index", method = RequestMethod.POST)
    public String Index(){
        return "你好，世界22";
    }

    /*测试Baidu重定向*/
    @RequestMapping(value="Baidu", method = RequestMethod.POST)
    public ModelAndView Index1(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:http://www.baidu.com");
        return mv;
    }


    @RequestMapping(value="local", method = RequestMethod.POST)
    public ModelAndView local(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/test1");
        return mv;
    }


    @RequestMapping(value="test1", method = RequestMethod.POST)
    public String test1(){
        return "你好，张三丰1";
    }

}
