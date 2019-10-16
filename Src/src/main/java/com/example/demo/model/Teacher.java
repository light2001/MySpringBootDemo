package com.example.demo.model;

import com.example.demo.enums.UserSexEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@Table(name="Teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer sex;
    private String name;
    private String remark;

    public Teacher() {
        super();
    }
}
