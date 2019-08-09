package com.example.demo.web;

import com.example.demo.model.ClassInfo;
import com.example.demo.service.ClassInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class ClassInfoController {
    @Autowired
    ClassInfoService service;

    @ApiOperation(value = "根据班级ID返回班级信息")
    @RequestMapping(value="/getClassInfo/{id}", method = RequestMethod.GET)
    public ClassInfo getClassInfo(@PathVariable("id") BigInteger id){
        return service.getClassInfo(id);
    }
}
