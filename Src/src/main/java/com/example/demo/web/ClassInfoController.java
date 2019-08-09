package com.example.demo.web;

import com.example.demo.model.ClassInfo;
import com.example.demo.service.ClassInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value="/ClassInfo")
public class ClassInfoController {
    @Autowired
    ClassInfoService service;

    @ApiOperation(value = "根据班级ID返回班级信息")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ClassInfo getClassInfo(@PathVariable("id") Long id) {
        ClassInfo info = service.getClassInfo(id);
        return info;
    }


    @ApiOperation(value = "根据班级ID返回班级信息")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<ClassInfo> getAll() {
        return service.getAllInfo();
    }

}
