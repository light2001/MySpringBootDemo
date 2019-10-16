package com.example.demo.service.impl;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.model.ClassInfo;
import com.example.demo.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassMapper mapper;

    @Override
    public ClassInfo getClassInfo(Long id) {
        //有两种方式：
        //1.调用crudRepository的接口
        return mapper.selectById(id);
        //2.调用我们自己写的接口
        //return repository.getClassInfo(id);
    }

    @Override
    public List<ClassInfo> getAllInfo() {
        return mapper.selectList(null);
    }
    @Override
    public Integer Delete(Long Id){

       return  mapper.deleteById(Id);
    }
    @Override
    public Integer Save(ClassInfo Input){
       return  mapper.insert(Input);
    }
}
