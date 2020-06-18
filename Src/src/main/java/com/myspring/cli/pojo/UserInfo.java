package com.myspring.cli.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class UserInfo {
    private String Name;
    private String Sex;
    private ArrayList<String> UrlList;
}
