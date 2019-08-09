package com.example.demo.model;

import com.example.demo.enums.UserSexEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name="Teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer sex;
    private String name;
    private String remark;

    public Teacher() {
        super();
    }
}
