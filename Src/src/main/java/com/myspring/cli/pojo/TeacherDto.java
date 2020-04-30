package com.myspring.cli.pojo;

import lombok.Data;

import java.util.List;
@Data
public class TeacherDto {
    private String Name;
    private Integer Age;
    private String Sex;
    private List<ClassInfoDto> ClassList;
}
