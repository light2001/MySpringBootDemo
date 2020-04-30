package com.myspring.cli.service;

import com.myspring.cli.model.ClassInfo;

public interface ClassInfoService {
    public ClassInfo getClassInfo(Long id);
    public Iterable<ClassInfo> getAllInfo();
    public void Delete(Long Id);
    public void Save(ClassInfo Input);
}
