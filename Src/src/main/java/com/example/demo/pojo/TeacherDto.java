package com.example.demo.pojo;

import lombok.Data;

import java.util.List;
@Data
public class TeacherDto {
    private String Name;
    private Integer Age;
    private String Sex;
    private List<ClassInfoDto> ClassList;
}
