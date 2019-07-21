package com.example.demo.web;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.Teacher;
import com.example.demo.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    private  TeacherMapper teacherMapper;
    @ApiOperation(value = "根据用户id查询教师")
    @RequestMapping(value="/getTeachers", method = RequestMethod.GET)
    public Teacher getTeachers() {
        Teacher teacher = new Teacher();
        long id=1;
        teacher.setId(id);
        teacher.setName("张三老师");
        teacher.setRemark("这里是备注");
        teacher.setSex(2);
        return teacher;
    }

    @ApiOperation(value = "获取信息")
    @RequestMapping(value="/GetInfo", method = RequestMethod.POST)
    public Teacher Insert(){
        Teacher teacher = new Teacher();

        teacher=this.teacherMapper.selectById(1);
        return teacher;
    }
}
