package com.example.demo.service;

import com.example.demo.model.ClassInfo;

import java.math.BigInteger;

public interface ClassInfoService {
    public ClassInfo getClassInfo(BigInteger id);
    public Iterable<ClassInfo> info();
}
