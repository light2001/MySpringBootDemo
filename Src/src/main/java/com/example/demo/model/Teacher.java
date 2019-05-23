package com.example.demo.model;

import com.example.demo.enums.UserSexEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer sex;
    private String name;
    private String remark;

    public Teacher() {
        super();
    }
}
