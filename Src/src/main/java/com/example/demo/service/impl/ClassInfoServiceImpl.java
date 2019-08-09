package com.example.demo.service.impl;

import com.example.demo.model.ClassInfo;
import com.example.demo.repo.ClassInfoRepository;
import com.example.demo.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;


@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    ClassInfoRepository repository;

    @Override
    public ClassInfo getClassInfo(BigInteger id){
        //有两种方式：
        //1.调用crudRepository的接口
//        return repository.findOne(id);
        //2.调用我们自己写的接口
        return repository.getClassInfo(id);
    }

    @Override
    public Iterable<ClassInfo> info(){
        return repository.findAll();
    }
}
