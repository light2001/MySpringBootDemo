package com.myspring.cli.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUser {
    private  String username ;
    private String password;
}
