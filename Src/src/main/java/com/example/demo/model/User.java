package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.enums.UserSexEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name();
    }
}