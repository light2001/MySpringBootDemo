package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name="class_info")
public class ClassInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="class_name")
    private String className;
    @Column(name="teacher_name")
    private String teacherName;
    @Column(name="grade_name")
    private String gradeName;
}
