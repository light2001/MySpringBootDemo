package com.example.demo.web;

import com.example.demo.model.ClassInfo;
import com.example.demo.service.ClassInfoService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@RestController
@RequestMapping(value="/Class")
public class ClassInfoController {
    @Autowired
    ClassInfoService service;

    @ApiOperation(value = "根据班级ID返回班级信息")
    @RequestMapping(value="/getClassInfo/{id}", method = RequestMethod.GET)
    public ClassInfo getClassInfo(@PathVariable("id") BigInteger id){
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        String querey=request.getParameter("id");
        String myid=request.getParameter("id");
        return service.getClassInfo(id);
    }

    @ApiOperation(value = "测试班级信息")
    @RequestMapping(value="/TestClassInfo", method = RequestMethod.POST)
    public ClassInfo Add(@RequestBody ClassInfo input){
        ClassInfo model = input;
        return model;
    }

    @ApiOperation(value = "测试班级信息,不加RequestBody")
    @RequestMapping(value="/TestClassInfoNOBody", method = RequestMethod.POST)
    public ClassInfo TestInfo(ClassInfo input){
        ClassInfo model = input;
        return model;
    }
}
