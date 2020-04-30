package com.myspring.cli.service;

import com.myspring.cli.model.Teacher;

public interface TeacherService {
    public Teacher get(Long id);
    public Iterable<Teacher> getAll();
    public void Delete(Long Id);
    public void Save(Teacher Input);
}
