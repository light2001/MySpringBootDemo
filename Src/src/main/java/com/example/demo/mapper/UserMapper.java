package com.example.demo.mapper;

import com.example.demo.enums.UserSexEnum;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "usersex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nickname")
    })
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "usersex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nickname")
    })
    User getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(User user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}