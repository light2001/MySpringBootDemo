package com.myspring.cli.web;

import com.myspring.cli.model.Teacher;
import com.myspring.cli.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @ApiOperation(value = "获取所有老师")
    @RequestMapping(value="/getTeachers", method = RequestMethod.GET)
    public Iterable<Teacher> getTeachers() {
        return service.getAll();
    }

    @ApiOperation(value = "根据ID获取信息")
    @RequestMapping(value="/GetInfo/{id}", method = RequestMethod.GET)
    public Teacher getInfo(@PathVariable("id") Long id){
        return service.get(id);
    }

    @ApiOperation(value = "根据ID删除信息")
    @RequestMapping(value="/Delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        service.Delete(id);
    }

    @ApiOperation(value = "更新，新增")
    @RequestMapping(value="/Update", method = RequestMethod.POST)
    public void Update(Teacher Input){
        service.Save(Input);
    }
}
