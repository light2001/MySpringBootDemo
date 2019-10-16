package com.example.demo.service.impl;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper mapper;

    @Override
    public Teacher get(Long Id){
        return mapper.selectById(Id);
    }
    @Override
    public List<Teacher> getAll(){
        return mapper.selectList(null);
    }
    @Override
    public int Delete(Long Id){
         return mapper.deleteById(Id);
    }
    @Override
    public int Save(Teacher Input){
        return mapper.insert(Input);
    }
}
