package com.example.demo.repo;

import com.example.demo.model.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ClassInfoRepository  extends CrudRepository<ClassInfo, Long> {

    @Query("from ClassInfo where id =:id ")
    public ClassInfo getClassInfo(@Param("id") Long id);
}
