package com.myspring.cli.service.impl;

import com.myspring.cli.model.Teacher;
import com.myspring.cli.repo.TeacherRepository;
import com.myspring.cli.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository repository;

    @Override
    public Teacher get(Long Id){
        return repository.findById(Id).get();
    }
    @Override
    public Iterable<Teacher> getAll(){
        return repository.findAll();
    }
    @Override
    public void Delete(Long Id){
        repository.deleteById(Id);
    }
    @Override
    public void Save(Teacher Input){
        repository.save(Input);
    }
}
