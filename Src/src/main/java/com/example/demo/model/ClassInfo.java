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
@Table(name="ClassInfo")
public class ClassInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    private String className;
    private String teacherName;
    private String gradeName;
}
