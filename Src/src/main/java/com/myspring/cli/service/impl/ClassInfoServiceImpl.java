package com.myspring.cli.service.impl;

import com.myspring.cli.model.ClassInfo;
import com.myspring.cli.repo.ClassInfoRepository;
import com.myspring.cli.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    ClassInfoRepository repository;

    @Override
    public ClassInfo getClassInfo(Long id) {
        //有两种方式：
        //1.调用crudRepository的接口
        return repository.findById(id).get();
        //2.调用我们自己写的接口
        //return repository.getClassInfo(id);
    }

    @Override
    public Iterable<ClassInfo> getAllInfo() {
        return repository.findAll();
    }
    @Override
    public void Delete(Long Id){
        repository.deleteById(Id);
    }
    @Override
    public void Save(ClassInfo Input){
        repository.save(Input);
    }
}
