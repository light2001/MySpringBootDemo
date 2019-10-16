package com.example.demo.service;

import com.example.demo.model.Teacher;

import java.util.List;

public interface ITeacherService {
    public Teacher get(Long id);
    public List<Teacher> getAll();
    public int Delete(Long Id);
    public int Save(Teacher Input);
}
