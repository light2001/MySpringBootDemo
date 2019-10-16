package com.example.demo.service;

import com.example.demo.model.ClassInfo;

import java.util.List;

public interface IClassInfoService {
    public ClassInfo getClassInfo(Long id);
    public List<ClassInfo> getAllInfo();
    public Integer Delete(Long Id);
    public Integer Save(ClassInfo Input);
}
