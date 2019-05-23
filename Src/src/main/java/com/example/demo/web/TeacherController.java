package com.example.demo.web;

import com.example.demo.model.Teacher;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @RequestMapping("/getTeachers")
    public Teacher getUsers() {
        Teacher teacher = new Teacher();
        long id=1;
        teacher.setId(id);
        teacher.setName("张三老师");
        teacher.setRemark("这里是备注");
        teacher.setSex(2);
        return teacher;
    }
}
