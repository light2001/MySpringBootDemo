package com.example.demo.service;

import com.example.demo.model.ClassInfo;

public interface ClassInfoService {
    public ClassInfo getClassInfo(Long id);
    public Iterable<ClassInfo> getAllInfo();
    public void Delete(Long Id);
    public void Save(ClassInfo Input);
}
