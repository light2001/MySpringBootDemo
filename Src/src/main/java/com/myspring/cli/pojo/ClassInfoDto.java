package com.myspring.cli.pojo;

import lombok.Data;

@Data
public class ClassInfoDto {
    private Long id;
    private String className;
    private String teacherName;
    private String gradeName;
    private String OtherName;
    private Integer status;
}
