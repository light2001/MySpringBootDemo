package com.myspring.cli.repo;

import com.myspring.cli.model.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoRepository  extends JpaRepository<ClassInfo, Long> {

    @Query("from ClassInfo where id =:id ")
    public ClassInfo getClassInfo(@Param("id") Long id);
}
